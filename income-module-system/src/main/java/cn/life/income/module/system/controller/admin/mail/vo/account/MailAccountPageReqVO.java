package cn.life.income.module.system.controller.admin.mail.vo.account;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 管理后台 - 邮箱账号分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailAccountPageReqVO extends PageParam {

    /**
     * 邮箱
     *
     * 用户邮箱地址。用于查询特定邮箱账号。
     * 示例：incomeyuanma@123.com
     */
    private String mail;

    /**
     * 用户名
     *
     * 邮箱账号的用户名。用于查询特定用户名的邮箱账号。
     * 示例：income
     */
    private String username;

}
