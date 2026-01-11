package cn.life.income.module.system.controller.admin.mail.vo.log;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 邮箱日志分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailLogPageReqVO extends PageParam {

    /**
     * 用户编号
     *
     * 用于标识邮箱日志对应的用户。
     * 示例：30883
     */
    private Long userId;

    /**
     * 用户类型
     *
     * 用户类型，参见 UserTypeEnum 枚举定义。用于区分不同类型的用户。
     * 示例：2
     */
    private Integer userType;

    /**
     * 接收邮箱地址
     *
     * 该邮箱地址接收到的邮件，支持模糊匹配。
     * 示例：76854@qq.com
     */
    private String toMail;

    /**
     * 邮箱账号编号
     *
     * 该日志记录的发送邮箱账号的编号。
     * 示例：18107
     */
    private Long accountId;

    /**
     * 模板编号
     *
     * 邮件使用的模板编号，帮助识别邮件内容模板。
     * 示例：5678
     */
    private Long templateId;

    /**
     * 发送状态
     *
     * 邮件发送状态，参见 MailSendStatusEnum 枚举。用于标识邮件是否成功发送。
     * 示例：1
     */
    private Integer sendStatus;

    /**
     * 发送时间
     *
     * 邮件发送的时间范围，用于过滤特定时间段内的日志。
     * 示例：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

}
