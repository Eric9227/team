package team.community.bean;

import lombok.Data;

/**
    * 信息表
    */
@Data
public class Message {
    /**
    * ID
    */
    private Integer id;

    /**
    * 专栏;所属的专栏
    */
    private String specialColumn;

    /**
    * 标题;标题
    */
    private String title;

    /**
    * 文章内容;文章的内容
    */
    private String content;

    /**
    * 悬赏数量;悬赏数量
    */
    private Integer reward;

    /**
    * 账号;发布人的账号
    */
    private String account;

    /**
    * 置顶;0代表不置顶，1代表置顶
    */
    private Integer top;

    /**
    * 加精;0代表不加精，1代表加精
    */
    private Integer digest;

    /**
    * VIP;0不为VIP
    */
    private Integer vip;
}