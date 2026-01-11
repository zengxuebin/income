package cn.life.income.module.system.controller.admin.mail.vo.account;

import lombok.Data;

/**
 * 管理后台 - 邮箱账号的精简 Response VO
 */
@Data
public class MailAccountSimpleRespVO {

    /**
     * 邮箱编号
     *
     * 唯一标识符，用于区分不同的邮箱账号。
     * 示例：1024
     */
    private Long id;

    /**
     * 邮箱
     *
     * 邮箱账号的邮箱地址，用于识别和联系该账号。
     * 示例：768541388@qq.com
     */
    private String mail;

}
