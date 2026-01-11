package cn.life.income.module.system.controller.admin.mail.vo.template;

import lombok.Data;

/**
 * 管理后台 - 邮件模板的精简响应对象
 *
 * 用于展示邮件模板的简要信息，包括模板编号和模板名称。
 */
@Data
public class MailTemplateSimpleRespVO {

    /**
     * 模板编号
     *
     * 邮件模板的唯一标识编号。
     */
    private Long id;

    /**
     * 模板名称
     *
     * 邮件模板的名称，用于标识该模板。
     */
    private String name;
}
