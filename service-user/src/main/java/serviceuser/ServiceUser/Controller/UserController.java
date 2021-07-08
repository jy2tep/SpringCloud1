package serviceuser.ServiceUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceuser.ServiceUser.From.UserForm;
import serviceuser.ServiceUser.Service.UserService;
import serviceuser.ServiceUser.sign.ResultCode;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.POST;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletResponse httpServletResponse;
    @RequestMapping(value = "siginin")
    public ResultCode userSignin(@Valid @RequestBody UserForm userForm){
        String xAuthtoken = userService.userCreate(userForm);
        httpServletResponse.setHeader("xAuthtoken",xAuthtoken);
        return new ResultCode(true,0,"注册成功");
    }
}
