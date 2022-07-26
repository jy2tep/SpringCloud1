package serviceuser.ServiceUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceuser.ServiceUser.From.UserForm;
import serviceuser.ServiceUser.From.UserNameFrom;
import serviceuser.ServiceUser.Service.UserService;
import serviceuser.ServiceUser.sign.ResponseResult;
import serviceuser.ServiceUser.sign.ResultCode;
import serviceuser.ServiceUser.sign.UserTokenVerification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletResponse httpServletResponse;
    @RequestMapping(value = "register")
    public ResponseResult<Map> userRegister(@Valid @RequestBody UserForm userForm){
        Map map = userService.userCreate(userForm);
        httpServletResponse.setHeader("xAuthtoken",String.valueOf(map.get("xAuthtoken")));
        return new ResponseResult<Map>(new ResultCode(true,0,"注册成功"),map);
    }

    @RequestMapping(value = "signin")
    public ResponseResult<Map> usersignin(@Valid @RequestBody UserForm userForm){
        Map map = userService.userSignin(userForm);
        httpServletResponse.setHeader("xAuthtoken",String.valueOf(map.get("xAuthtoken")));
        return new ResponseResult<Map>(new ResultCode(true,0,"登录成功"),map);
    }
}
