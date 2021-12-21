package team.community.bean;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import team.community.annotation.FieldName;

/**
 * 留言板
 * @author TAN00XU
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
    @FieldName("author_add_time")
    private LocalDateTime authorAddTime;

    /**
     * 留言;阅读者的留言
     */
    @FieldName("leave_word")
    private String leaveWord;

    /**
     * 留言者的账号;留言者的账号
     */
    @FieldName("leave_word_account")
    private String leaveWordAccount;

    /**
     * 留言的时间;留言的时间
     */
    @FieldName("leave_add_time")
    private LocalDateTime leaveAddTime;

    /**
     * 置顶;0代表不置顶，1代表置顶
     */
    private Boolean top;

    /**
     * 加精;0代表不加精，1代表加精
     */
    private Boolean digest;
}