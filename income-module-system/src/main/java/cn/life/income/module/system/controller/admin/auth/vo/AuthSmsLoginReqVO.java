package cn.life.income.module.system.controller.admin.auth.vo;

import cn.life.income.framework.common.validation.Mobile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;

/**
 * 管理后台 - 短信验证码的登录 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSmsLoginReqVO {

    /**
     * 手机号
     * 必须填写，且必须符合手机号格式
     */
    @NotEmpty(message = "手机号不能为空")
    @Mobile
    private String mobile;

    /**
     * 短信验证码
     * 必须填写
     */
    @NotEmpty(message = "验证码不能为空")
    private String code;

}
