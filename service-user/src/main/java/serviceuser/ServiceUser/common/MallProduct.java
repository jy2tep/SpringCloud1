package serviceuser.ServiceUser.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mall_product")
public class MallProduct implements Serializable {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
    @Column(name = "id")
    private Integer id;
    //用户名
    @Column(name = "category_id")
    private String categoryid;
    //用户密码
    @Column(name = "name")
    private String name;
    //邮箱
    @Column(name = "subtitle")
    private String subtitle;
    //电话
    @Column(name = "mainimage")
    private String mainimage;
    //找回密码问题
    @Column(name="subimages")
    private String subimages;
    //找回密码答案
    @Column(name="detail")
    private String detail;
    //角色
    @Column(name="price")
    private Integer price;
    //创建时间
    @Column(name="stock")
    private Date stock;
    //最后一次更新时间
    @Column(name="status")
    private Date status;
    //创建时间
    @Column(name="create_time")
    private Date createtime;
    //修改时间
    @Column(name="update_time")
    private Date updatetime;
}
