package team.community.bean;

import java.util.Date;
import lombok.Data;

/**
    * 留言板
    */
@Data
public class MessageBoard {
    /**
    * ID
    */
    private Integer id;

    /**
    * 留言;阅读者的留言
    */
    private String leaveWord;

    /**
    * 留言者的账号;留言者的账号
    */
    private String leaveWordAccount;

    /**
    * 留言的时间;留言的时间
    */
    private Date addTime;

    /**
    * 置顶;0代表不置顶，1代表置顶
    */
    private Integer top;

    /**
    * 加精;0代表不加精，1代表加精
    */
    private Integer digest;
}