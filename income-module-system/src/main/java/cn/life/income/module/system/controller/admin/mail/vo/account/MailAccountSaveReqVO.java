package cn.life.income.module.system.controller.admin.mail.vo.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 管理后台 - 邮箱账号创建/修改 Request VO
 */
@Data
public class MailAccountSaveReqVO {

    /**
     * 编号
     *
     * 邮箱账号的唯一标识符。通常用于更新或删除特定账号。
     * 示例：1024
     */
    private Long id;

    /**
     * 邮箱
     *
     * 用户邮箱地址。必须符合邮箱格式的要求。
     * 示例：incomeyuanma@123.com
     */
    @NotNull(message = "邮箱不能为空")
    @Email(message = "必须是 Email 格式")
    private String mail;

    /**
     * 用户名
     *
     * 邮箱账号的用户名。不能为空。
     * 示例：income
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     *
     * 邮箱账号的密码。不能为空。
     * 示例：123456
     */
    @NotNull(message = "密码必填")
    private String password;

    /**
     * SMTP 服务器域名
     *
     * 用于邮件发送的 SMTP 服务器域名。不能为空。
     * 示例：www.iocoder.cn
     */
    @NotNull(message = "SMTP 服务器域名不能为空")
    private String host;

    /**
     * SMTP 服务器端口
     *
     * 用于邮件发送的 SMTP 服务器端口。不能为空。
     * 示例：80
     */
    @NotNull(message = "SMTP 服务器端口不能为空")
    private Integer port;

    /**
     * 是否开启 ssl
     *
     * 是否启用 SSL 加密连接，提升安全性。不能为空。
     * 示例：true
     */
    @NotNull(message = "是否开启 ssl 必填")
    private Boolean sslEnable;

    /**
     * 是否开启 starttls
     *
     * 是否启用 STARTTLS 协议，提升安全性。不能为空。
     * 示例：true
     */
    @NotNull(message = "是否开启 starttls 必填")
    private Boolean starttlsEnable;

}
