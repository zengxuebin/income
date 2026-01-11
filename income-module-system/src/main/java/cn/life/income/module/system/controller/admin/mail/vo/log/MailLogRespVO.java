package cn.life.income.module.system.controller.admin.mail.vo.log;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 管理后台 - 邮件日志 Response VO
 */
@Data
public class MailLogRespVO {

    /**
     * 编号
     *
     * 唯一标识邮件日志记录的编号。
     * 示例：31020
     */
    private Long id;

    /**
     * 用户编号
     *
     * 发送邮件的用户编号。
     * 示例：30883
     */
    private Long userId;

    /**
     * 用户类型
     *
     * 用户类型，参见 UserTypeEnum 枚举定义。用于标识用户类型。
     * 示例：2
     */
    private Byte userType;

    /**
     * 接收邮箱地址
     *
     * 该邮件的接收者邮箱地址，支持多个邮箱地址。
     * 示例：user1@example.com, user2@example.com
     */
    private List<String> toMails;

    /**
     * 抄送邮箱地址
     *
     * 该邮件的抄送邮箱地址，支持多个邮箱地址。
     * 示例：user3@example.com, user4@example.com
     */
    private List<String> ccMails;

    /**
     * 密送邮箱地址
     *
     * 该邮件的密送邮箱地址，支持多个邮箱地址。
     * 示例：user5@example.com, user6@example.com
     */
    private List<String> bccMails;

    /**
     * 邮箱账号编号
     *
     * 该邮件日志记录的邮箱账号编号。
     * 示例：18107
     */
    private Long accountId;

    /**
     * 发送邮箱地址
     *
     * 发送邮件的邮箱地址。
     * 示例：85757@qq.com
     */
    private String fromMail;

    /**
     * 模板编号
     *
     * 邮件使用的模板编号，用于识别模板。
     * 示例：5678
     */
    private Long templateId;

    /**
     * 模板编码
     *
     * 邮件模板的编码标识符。
     * 示例：test_01
     */
    private String templateCode;

    /**
     * 模版发送人名称
     *
     * 邮件模板中的发送人名称。
     * 示例：李四
     */
    private String templateNickname;

    /**
     * 邮件标题
     *
     * 邮件的标题内容。
     * 示例：测试标题
     */
    private String templateTitle;

    /**
     * 邮件内容
     *
     * 邮件的具体内容。
     * 示例：测试内容
     */
    private String templateContent;

    /**
     * 邮件参数
     *
     * 邮件模板的动态参数，键值对形式。
     */
    private Map<String, Object> templateParams;

    /**
     * 发送状态
     *
     * 邮件发送状态，参见 MailSendStatusEnum 枚举定义。
     * 示例：1
     */
    private Byte sendStatus;

    /**
     * 发送时间
     *
     * 邮件发送的时间。
     */
    private LocalDateTime sendTime;

    /**
     * 发送返回的消息 ID
     *
     * 邮件发送的消息 ID，用于追踪邮件发送状态。
     * 示例：28568
     */
    private String sendMessageId;

    /**
     * 发送异常
     *
     * 邮件发送过程中出现的异常信息。
     */
    private String sendException;

    /**
     * 创建时间
     *
     * 邮件日志记录的创建时间。
     */
    private LocalDateTime createTime;

}
