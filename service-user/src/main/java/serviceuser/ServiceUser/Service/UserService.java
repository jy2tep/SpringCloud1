package serviceuser.ServiceUser.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import serviceuser.ServiceUser.Excep.UserException;
import serviceuser.ServiceUser.From.UserForm;
import serviceuser.ServiceUser.Mapper.VipDao;
import serviceuser.ServiceUser.common.Vip;
import serviceuser.ServiceUser.sign.ResultCode;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    VipDao userMapper;

    //注册会员
    public String userCreate(UserForm userForm){
        Vip vip = new Vip();
        vip.setAccount(userForm.getCount());
        String str = "-"+userForm.getPassword()+"-";
        vip.setPassword(md5(str).toUpperCase());
        Vip userfind = userMapper.findByAccount(vip.getAccount());
        if (null!=userfind){
            throw new UserException(new ResultCode(false,-1,"当前注册的账号已经存在!"));
        }
        userMapper.save(vip);
        String xAutoken = getxAuthToken(vip);
        return xAutoken;
    }
    //md5加密封装
    public String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    //获取当前用户的token值并写入redis
    public String getxAuthToken(Vip vip){
        String xAutoken = md5(vip.getAccount()+System.currentTimeMillis()).toUpperCase();
        redisTemplate.boundSetOps(xAutoken).add(vip.getAccount());
        redisTemplate.expire(xAutoken,25, TimeUnit.MINUTES);
        return xAutoken;
    }

}
