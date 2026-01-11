package cn.life.income.module.system.controller.admin.oauth2.vo.client;

import cn.hutool.core.util.StrUtil;
import cn.life.income.framework.common.util.json.JsonUtils;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * 管理后台 - OAuth2 客户端创建/修改请求 VO (Value Object)
 * 用于接收前端传入的 OAuth2 客户端的创建和修改请求。
 */
@Data
public class OAuth2ClientSaveReqVO {

    /**
     * 客户端编号
     * 唯一标识每个 OAuth2 客户端。
     */
    private Long id;

    /**
     * 客户端编号
     * 该字段是必填项，表示客户端的唯一标识符。
     */
    @NotNull(message = "客户端编号不能为空")
    private String clientId;

    /**
     * 客户端密钥
     * 该字段是必填项，表示 OAuth2 客户端的密钥。
     */
    @NotNull(message = "客户端密钥不能为空")
    private String secret;

    /**
     * 应用名
     * 该字段是必填项，表示应用的名称。
     */
    @NotNull(message = "应用名不能为空")
    private String name;

    /**
     * 应用图标
     * 该字段是必填项，表示应用的图标 URL 地址。
     */
    @NotNull(message = "应用图标不能为空")
    @URL(message = "应用图标的地址不正确")
    private String logo;

    /**
     * 应用描述
     * 该字段是可选项，用于提供应用的简短描述。
     */
    private String description;

    /**
     * 状态
     * 该字段是必填项，表示 OAuth2 客户端的状态。
     * 状态参考枚举 `CommonStatusEnum`。
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 访问令牌的有效期
     * 该字段是必填项，表示访问令牌的有效时间（单位：秒）。
     */
    @NotNull(message = "访问令牌的有效期不能为空")
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新令牌的有效期
     * 该字段是必填项，表示刷新令牌的有效时间（单位：秒）。
     */
    @NotNull(message = "刷新令牌的有效期不能为空")
    private Integer refreshTokenValiditySeconds;

    /**
     * 可重定向的 URI 地址
     * 该字段是必填项，表示允许的重定向 URI 列表。
     */
    @NotNull(message = "可重定向的 URI 地址不能为空")
    private List<@NotEmpty(message = "重定向的 URI 不能为空") @URL(message = "重定向的 URI 格式不正确") String> redirectUris;

    /**
     * 授权类型
     * 该字段是必填项，表示授权类型列表，参考 `OAuth2GrantTypeEnum` 枚举。
     */
    @NotNull(message = "授权类型不能为空")
    private List<String> authorizedGrantTypes;

    /**
     * 授权范围
     * 该字段是可选项，表示允许的授权范围。
     */
    private List<String> scopes;

    /**
     * 自动通过的授权范围
     * 该字段是可选项，表示无需用户授权即可通过的授权范围。
     */
    private List<String> autoApproveScopes;

    /**
     * 权限
     * 该字段是可选项，表示应用所需的权限列表。
     */
    private List<String> authorities;

    /**
     * 资源
     * 该字段是可选项，表示 OAuth2 客户端支持的资源。
     */
    private List<String> resourceIds;

    /**
     * 附加信息
     * 该字段是可选项，表示额外的 JSON 格式的附加信息。
     * 必须符合 JSON 格式。
     */
    private String additionalInformation;

    /**
     * 验证附加信息是否符合 JSON 格式。
     * 如果附加信息不为空，必须是有效的 JSON 格式。
     *
     * @return 如果附加信息符合 JSON 格式，返回 true；否则返回 false。
     */
    @AssertTrue(message = "附加信息必须是 JSON 格式")
    public boolean isAdditionalInformationJson() {
        return StrUtil.isEmpty(additionalInformation) || JsonUtils.isJson(additionalInformation);
    }
}
