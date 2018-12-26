package com.wangkf.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "tb_user")
@Data //自动为属性getter和setter以及方法
public class User {
    @Id //id设置(通用mapper的增删改查会用)
    @KeySql(useGeneratedKeys = true) //主键设置
    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;

    //@Transient //表示不是表中字段
    //private int age;

}
