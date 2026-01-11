package cn.life.income.module.system.controller.admin.auth.vo;

import cn.life.income.framework.common.validation.InEnum;
import cn.life.income.module.system.enums.social.SocialTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 社交绑定登录 Request VO，使用 code 授权码 + 账号密码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSocialLoginReqVO {

    /**
     * 社交平台的类型，参见 SocialTypeEnum 枚举值
     * 必须填写，且必须是 SocialTypeEnum 枚举中的一个值
     */
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "社交平台的类型不能为空")
    private Integer type;

    /**
     * 授权码
     * 必须填写
     */
    @NotEmpty(message = "授权码不能为空")
    private String code;

    /**
     * state
     * 必须填写
     */
    @NotEmpty(message = "state 不能为空")
    private String state;

}
