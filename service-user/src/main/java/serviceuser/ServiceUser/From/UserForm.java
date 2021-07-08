package serviceuser.ServiceUser.From;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    @NotEmpty(message = "账号不能为空")
    private String count;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
