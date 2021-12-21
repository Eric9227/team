package team.community.bean;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import team.community.annotation.FieldName;

/**
 * 信息表
 */
@Data
public class Message {
    /**
     * 账号;发布人的账号
     */
    private String account;

    /**
     * 时间;发布的时间
     */
    @FieldName("add_time")
    private LocalDateTime addTime; // LocalDate\LocalTime

    /**
     * 专栏;所属的专栏
     */
    @FieldName("special_column")
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
     * 置顶;0代表不置顶，1代表置顶
     */
    private Boolean top;

    /**
     * 加精;0代表不加精，1代表加精
     */
    private Boolean digest;
}