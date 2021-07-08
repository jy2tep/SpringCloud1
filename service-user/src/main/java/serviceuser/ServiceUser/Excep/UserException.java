package serviceuser.ServiceUser.Excep;

import lombok.Data;
import serviceuser.ServiceUser.sign.ResultCode;

@Data
public class UserException extends RuntimeException{

    private ResultCode resultCode;

    public UserException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public UserException() {
    }

    public ResultCode getExceptionEnum() {
        return resultCode;
    }

    public void setExceptionEnum(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

}
