package serviceuser.ServiceUser.Service;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import serviceuser.ServiceUser.Excep.UserException;
import serviceuser.ServiceUser.Mapper.From.UserForm;
import serviceuser.ServiceUser.Mapper.MallUserDao;
import serviceuser.ServiceUser.common.MallProduct;
import serviceuser.ServiceUser.common.MallUser;
import serviceuser.ServiceUser.sign.ResultCode;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    MallUserDao userMapper;

    //注册会员
    public Map userCreate(UserForm userForm){
        MallUser mallUser = new MallUser();
        Map map = new HashMap();
        mallUser.setUsername(userForm.getName());
        String str = "-"+userForm.getPassword()+"-";
        mallUser.setPassword(md5(str).toUpperCase());
        mallUser.setCreatetime(new Date());
        mallUser.setUpdatetime(new Date());
        mallUser.setRole(1);
        List<MallUser> list = userMapper.findAllByUsernameIs(mallUser.getUsername());
        if (list.size()>0){
            throw new UserException(new ResultCode(false,-1,"当前注册的账号已经存在!"));
        }
        userMapper.save(mallUser);
        list = userMapper.findAllByUsernameIs(mallUser.getUsername());
        String xAuthtoken = getxAuthToken(mallUser);
        map.put("id",list.get(0).getId());
        map.put("token",xAuthtoken);
        map.put("name",list.get(0).getUsername());
        return map;
    }
    //会员登录
    public Map userSignin(UserForm userForm){
        List<MallUser> list = userMapper.findAllByUsernameIs(userForm.getName());
        String str = "-"+userForm.getPassword()+"-";
        str = md5(str).toUpperCase();
        if (list.size()==0){
            throw new UserException(new ResultCode(false,-1,"需要登录的账号不存在"));
        }
        else if (!str.equals(list.get(0).getPassword())) {
            throw new UserException(new ResultCode(false,-1,"密码错误"));
        }
        String xAuthtoken = getxAuthToken(list.get(0));
        Map map = new HashMap();
        map.put("id",list.get(0).getId());
        map.put("token",xAuthtoken);
        map.put("name",list.get(0).getUsername());
        return map;
    }

    //md5加密封装
    public String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    //获取当前用户的token值并写入redis
    public String getxAuthToken(MallUser mallUser){
        String xAutoken = md5(mallUser.getUsername()+System.currentTimeMillis()).toUpperCase();
        redisTemplate.boundValueOps(xAutoken).set(mallUser.getUsername());
        redisTemplate.expire(xAutoken,25, TimeUnit.MINUTES);
        return xAutoken;
    }


    public void getAuthToken(int id){
        //获取对应的商品信息并返回
        MallProduct mallProduct = userMapper.getStock(1);
        logger.info(JSONObject.toJSONString(mallProduct));
    }

}
