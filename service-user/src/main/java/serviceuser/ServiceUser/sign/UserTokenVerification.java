package serviceuser.ServiceUser.sign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import serviceuser.ServiceUser.Excep.UserException;

import javax.annotation.PostConstruct;
@Component
public class UserTokenVerification {

    private static RedisTemplate redisTemplate;

    @Autowired
    private void setRedisTemplate(RedisTemplate redisTemplate){
     UserTokenVerification.redisTemplate  = redisTemplate;
    }

//    @PostConstruct
//    public void init(){UserTokenVerification.redisTemplate =redisTemplateProx;
//    }
    public static String getUser(String xAuthToken){
        if (!redisTemplate.hasKey(xAuthToken)){
            throw new UserException(new ResultCode(false,-1,"当前登录的会话已经失效"));
        }
        else {
            return String.valueOf(redisTemplate.boundValueOps(xAuthToken).get());
        }
    }
}
