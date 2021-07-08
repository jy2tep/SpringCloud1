package serviceuser.ServiceUser.sign;

public class ResponseResult<T> {
    private boolean success;//是否操作成功
    private Integer code;//操作状态码，rest风格
    private String message;//操作结果详细信息
    private T data;//实体类数据

    public ResponseResult(ResultCode rc) {
        this.success = rc.success;
        this.code = rc.code;
        this.message = rc.message;
    }

    public ResponseResult(ResultCode rc, T data) {
        this.success = rc.success;
        this.code = rc.code;
        this.message = rc.message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
