package serviceuser.ServiceUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceuser.ServiceUser.From.UserForm;
import serviceuser.ServiceUser.Service.UserService;
import serviceuser.ServiceUser.sign.ResponseResult;
import serviceuser.ServiceUser.sign.ResultCode;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/user/handle/")
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
