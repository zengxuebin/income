package cn.life.income.module.system.controller.admin.mail.vo.template;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - 邮件模板响应对象
 *
 * 用于返回邮件模板的详细信息，包括模板的基本信息、状态、参数等。
 */
@Data
public class MailTemplateRespVO {

    /**
     * 编号
     *
     * 唯一标识邮件模板的ID。
     */
    private Long id;

    /**
     * 模板名称
     *
     * 邮件模板的名称。
     */
    private String name;

    /**
     * 模板编号
     *
     * 唯一标识一个邮件模板的编号。
     */
    private String code;

    /**
     * 发送的邮箱账号编号
     *
     * 表示该模板使用的邮箱账号的编号。
     */
    private Long accountId;

    /**
     * 发送人名称
     *
     * 邮件模板中发件人的名称。
     */
    private String nickname;

    /**
     * 标题
     *
     * 邮件模板的标题。
     */
    private String title;

    /**
     * 内容
     *
     * 邮件模板的内容。
     */
    private String content;

    /**
     * 参数数组
     *
     * 模板中使用的参数名称列表（如：name, code）。
     */
    private List<String> params;

    /**
     * 状态
     *
     * 邮件模板的状态，参见 `CommonStatusEnum` 枚举。
     */
    private Integer status;

    /**
     * 备注
     *
     * 邮件模板的备注信息。
     */
    private String remark;

    /**
     * 创建时间
     *
     * 邮件模板的创建时间。
     */
    private LocalDateTime createTime;

}
