package cn.life.income.module.system.controller.admin.sms.vo.channel;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 短信渠道响应对象
 */
@Data
public class SmsChannelRespVO {

    /**
     * 短信渠道编号
     *
     * 短信渠道编号
     */
    private Long id;

    /**
     * 短信签名
     *
     * 短信签名
     */
    @NotNull(message = "短信签名不能为空")
    private String signature;

    /**
     * 渠道编码，参见 SmsChannelEnum 枚举类
     *
     * 渠道编码
     */
    private String code;

    /**
     * 启用状态
     *
     * 启用状态
     */
    @NotNull(message = "启用状态不能为空")
    private Integer status;

    /**
     * 备注
     *
     * 备注
     */
    private String remark;

    /**
     * 短信 API 的账号
     *
     * 短信 API 账号
     */
    @NotNull(message = "短信 API 的账号不能为空")
    private String apiKey;

    /**
     * 短信 API 的密钥
     *
     * 短信 API 密钥
     */
    private String apiSecret;

    /**
     * 短信发送回调 URL
     *
     * 回调 URL
     */
    @URL(message = "回调 URL 格式不正确")
    private String callbackUrl;

    /**
     * 创建时间
     *
     * 创建时间
     */
    private LocalDateTime createTime;

}
