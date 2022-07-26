package serviceuser.ServiceUser.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mall_user")
public class Vip implements Serializable {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
    @Column(name = "id")
    private Integer id;
    //用户名
    @Column(name = "username")
    private String username;
    //用户密码
    @Column(name = "password")
    private String password;
    //邮箱
    @Column(name = "email")
    private String email;
    //电话
    @Column(name = "phone")
    private String phone;
    //找回密码问题
    @Column(name="question")
    private String question;
    //找回密码答案
    @Column(name="answer")
    private String answer;
    //角色
    @Column(name="role")
    private Integer role;
    //创建时间
    @Column(name="create_time")
    private Date create_time;
    //最后一次更新时间
    @Column(name="update_time")
    private Date update_time;
}
