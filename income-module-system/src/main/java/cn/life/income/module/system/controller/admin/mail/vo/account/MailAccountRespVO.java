package cn.life.income.module.system.controller.admin.mail.vo.account;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 管理后台 - 邮箱账号 Response VO
 */
@Data
public class MailAccountRespVO {

    /**
     * 编号
     *
     * 邮箱账号的唯一标识符。通常用于查询或标识特定的邮箱账号。
     * 示例：1024
     */
    private Long id;

    /**
     * 邮箱
     *
     * 邮箱账号的邮箱地址。用于邮件发送和接收。
     * 示例：incomeyuanma@123.com
     */
    private String mail;

    /**
     * 用户名
     *
     * 邮箱账号的用户名。用于登录或其他认证目的。
     * 示例：income
     */
    private String username;

    /**
     * 密码
     *
     * 邮箱账号的密码。用于验证用户身份。
     * 示例：123456
     */
    private String password;

    /**
     * SMTP 服务器域名
     *
     * 用于邮件发送的 SMTP 服务器的域名。
     * 示例：www.iocoder.cn
     */
    private String host;

    /**
     * SMTP 服务器端口
     *
     * 用于邮件发送的 SMTP 服务器端口号。
     * 示例：80
     */
    private Integer port;

    /**
     * 是否开启 ssl
     *
     * 是否启用 SSL 加密连接，确保邮件传输的安全性。
     * 示例：true
     */
    private Boolean sslEnable;

    /**
     * 是否开启 starttls
     *
     * 是否启用 STARTTLS 协议来提升邮件传输的安全性。
     * 示例：true
     */
    private Boolean starttlsEnable;

    /**
     * 创建时间
     *
     * 邮箱账号的创建时间，记录账号的创建日期。
     * 示例：2022-01-01T12:00:00
     */
    private LocalDateTime createTime;

}
