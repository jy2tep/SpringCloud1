package serviceuser.ServiceUser.sign;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import serviceuser.ServiceUser.Excep.UserException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(UserException.class)
    @ResponseBody
    public ResponseResult<Void> exceptionHandle(UserException e){
        ResultCode rc = e.getExceptionEnum();
        List<Integer> list = new ArrayList<>();
        return new ResponseResult<>(rc);
    }
}