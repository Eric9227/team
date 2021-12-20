package team.community.bean;

import lombok.Data;

/**
    * 用户表
    */
@Data
public class User {
    /**
    * ID
    */
    private Integer id;

    /**
    * 用户名;用户名
    */
    private String username;

    /**
    * 账号;账号
    */
    private String account;

    /**
    * 密码;密码
    */
    private String password;

    /**
    * 头像;头像的url地址
    */
    private String avatar;

    /**
    * 年龄;用户年龄
    */
    private Integer age;

    /**
    * 性别;0为女，1为男
    */
    private Integer gender;
}