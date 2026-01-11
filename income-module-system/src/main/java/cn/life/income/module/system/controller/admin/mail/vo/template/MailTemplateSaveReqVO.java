package cn.life.income.module.system.controller.admin.mail.vo.template;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 管理后台 - 邮件模板创建/修改请求对象
 *
 * 用于接收前端传递的邮件模板数据，在创建或修改邮件模板时使用。
 */
@Data
public class MailTemplateSaveReqVO {

    /**
     * 编号
     *
     * 唯一标识一个邮件模板的ID，在更新操作时使用。
     */
    private Long id;

    /**
     * 模板名称
     *
     * 邮件模板的名称，不能为空。
     */
    @NotNull(message = "名称不能为空")
    private String name;

    /**
     * 模板编号
     *
     * 唯一标识一个邮件模板的编号，不能为空。
     */
    @NotNull(message = "模板编号不能为空")
    private String code;

    /**
     * 发送的邮箱账号编号
     *
     * 表示该模板使用的邮箱账号的编号，不能为空。
     */
    @NotNull(message = "发送的邮箱账号编号不能为空")
    private Long accountId;

    /**
     * 发送人名称
     *
     * 邮件模板中发件人的名称，非必填项。
     */
    private String nickname;

    /**
     * 邮件标题
     *
     * 邮件模板的标题，不能为空。
     */
    @NotEmpty(message = "标题不能为空")
    private String title;

    /**
     * 邮件内容
     *
     * 邮件模板的内容，不能为空。
     */
    @NotEmpty(message = "内容不能为空")
    private String content;

    /**
     * 状态
     *
     * 邮件模板的状态，参见 `CommonStatusEnum` 枚举，不能为空。
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 备注
     *
     * 邮件模板的备注信息，非必填项。
     */
    private String remark;
}
