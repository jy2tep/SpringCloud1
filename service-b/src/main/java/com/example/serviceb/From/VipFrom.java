package com.example.serviceb.From;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class VipFrom {

    private Integer id;

    private String mobile;

    private String password;

    private String name;

    private String account;

    private String headurl;
}
