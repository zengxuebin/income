package cn.life.income.module.system.controller.admin.socail.vo.user;

import cn.life.income.module.system.enums.social.SocialTypeEnum;
import cn.life.income.framework.common.validation.InEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 管理后台 - 社交绑定 Request VO，使用 code 授权码
 *
 * 该对象用于社交平台授权绑定的请求参数，包含社交平台类型、授权码、以及状态标识。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialUserBindReqVO {

    /**
     * 社交平台的类型，参见 UserSocialTypeEnum 枚举值
     * 此字段指定了用户绑定的社交平台类型。
     */
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "社交平台的类型不能为空")
    private Integer type;

    /**
     * 授权码，用于绑定社交平台
     * 该字段是从社交平台返回的授权码，必须在绑定时提供。
     */
    @NotEmpty(message = "授权码不能为空")
    private String code;

    /**
     * 状态标识
     * 该字段用于记录请求的状态标识，通常在 OAuth2 流程中由社交平台返回。
     */
    @NotEmpty(message = "state 不能为空")
    private String state;
}
