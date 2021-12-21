package team.community.bean;

import java.util.Date;
import lombok.Data;

/**
 * 留言板
 */
@Data
public class MessageBoard {
    /**
     * 账号;发布人的账号
     */
    private String account;

    /**
     * 时间;作者发布的时间
     */
    private Date authorAddTime;

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