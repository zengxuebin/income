package cn.life.income.module.system.controller.admin.auth.vo;

import cn.life.income.framework.common.validation.Mobile;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * 管理后台 - 短信重置账号密码 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResetPasswordReqVO {

    /**
     * 密码
     * 必须填写，长度为 4-16 位
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

    /**
     * 手机号
     * 必须填写，且必须符合手机号格式
     */
    @NotEmpty(message = "手机号不能为空")
    @Mobile
    private String mobile;

    /**
     * 手机短信验证码
     * 必须填写
     */
    @NotEmpty(message = "手机短信验证码不能为空")
    private String code;
}