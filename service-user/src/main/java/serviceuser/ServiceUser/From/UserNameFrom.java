package serviceuser.ServiceUser.From;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserNameFrom {

    private String name;

    private String age;
}