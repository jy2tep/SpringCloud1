package serviceuser.ServiceUser.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import serviceuser.ServiceUser.Excep.UserException;
import serviceuser.ServiceUser.From.UserForm;
import serviceuser.ServiceUser.From.UserNameFrom;
import serviceuser.ServiceUser.Mapper.VipDao;
import serviceuser.ServiceUser.common.Vip;
import serviceuser.ServiceUser.sign.ResultCode;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    VipDao userMapper;

    //注册会员
    public Map userCreate(UserForm userForm){
        Vip vip = new Vip();
        Map map = new HashMap();
        vip.setUsername(userForm.getCount());
        String str = "-"+userForm.getPassword()+"-";
        vip.setPassword(md5(str).toUpperCase());
        List<Vip> list = userMapper.findByAccount(vip.getUsername());
        if (list.size()>0){
            throw new UserException(new ResultCode(false,-1,"当前注册的账号已经存在!"));
        }
        userMapper.save(vip);
        String xAuthtoken = getxAuthToken(vip);
        map.put("xAuthtoken",xAuthtoken);
        return map;
    }
    //会员登录
    public Map userSignin(UserForm userForm){
        List<Vip> list = userMapper.findByAccount(userForm.getCount());
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
        map.put("xAuthtoken",xAuthtoken);
        map.put("account",list.get(0).getUsername());
        return map;
    }

    //md5加密封装
    public String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    //获取当前用户的token值并写入redis
    public String getxAuthToken(Vip vip){
        String xAutoken = md5(vip.getUsername()+System.currentTimeMillis()).toUpperCase();
        redisTemplate.boundValueOps(xAutoken).set(vip.getUsername());
        redisTemplate.expire(xAutoken,25, TimeUnit.MINUTES);
        return xAutoken;
    }

}
