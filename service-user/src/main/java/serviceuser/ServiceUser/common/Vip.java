package serviceuser.ServiceUser.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "vip")
public class Vip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
    @Column(name = "id")
    private Integer id;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "account")
    private String account;

    @Column(name="headurl")
    private String headurl;
}
