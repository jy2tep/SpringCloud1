package com.example.servicea.Excep;

import com.example.servicea.sign.ResultCode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
