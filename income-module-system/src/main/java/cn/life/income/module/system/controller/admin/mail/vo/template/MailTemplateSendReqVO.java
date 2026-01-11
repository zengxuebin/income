package cn.life.income.module.system.controller.admin.mail.vo.template;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 管理后台 - 邮件发送请求对象
 *
 * 用于发送邮件的请求参数，包括接收邮箱、抄送、密送、模板编码和模板参数。
 */
@Data
public class MailTemplateSendReqVO {

    /**
     * 接收邮箱列表
     *
     * 用于接收邮件的邮箱地址列表，不能为空。
     */
    @NotEmpty(message = "接收邮箱不能为空")
    private List<String> toMails;

    /**
     * 抄送邮箱列表
     *
     * 抄送邮件的邮箱地址列表，可选项。
     */
    private List<String> ccMails;

    /**
     * 密送邮箱列表
     *
     * 密送邮件的邮箱地址列表，可选项。
     */
    private List<String> bccMails;

    /**
     * 模板编码
     *
     * 邮件模板的唯一编码，用于区分不同的邮件模板，不能为空。
     */
    @NotNull(message = "模板编码不能为空")
    private String templateCode;

    /**
     * 模板参数
     *
     * 用于模板渲染的参数，键值对的形式。
     */
    private Map<String, Object> templateParams;

}
