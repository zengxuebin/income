package cn.life.income.module.system.controller.admin.oauth2.vo.client;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - OAuth2 客户端响应 VO (Value Object)
 * 用于返回前端 OAuth2 客户端的详细信息。
 */
@Data
public class OAuth2ClientRespVO {

    /**
     * 客户端编号
     * 唯一标识每个 OAuth2 客户端。
     */
    private Long id;

    /**
     * 客户端编号
     * 该字段表示 OAuth2 客户端的唯一标识符。
     */
    private String clientId;

    /**
     * 客户端密钥
     * 该字段表示 OAuth2 客户端的密钥。
     */
    private String secret;

    /**
     * 应用名
     * 该字段表示应用的名称。
     */
    private String name;

    /**
     * 应用图标
     * 该字段表示应用的图标 URL 地址。
     */
    private String logo;

    /**
     * 应用描述
     * 该字段用于提供应用的简短描述。
     */
    private String description;

    /**
     * 状态
     * 该字段表示 OAuth2 客户端的状态。
     * 状态参考枚举 `CommonStatusEnum`。
     */
    private Integer status;

    /**
     * 访问令牌的有效期
     * 该字段表示访问令牌的有效时间（单位：秒）。
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新令牌的有效期
     * 该字段表示刷新令牌的有效时间（单位：秒）。
     */
    private Integer refreshTokenValiditySeconds;

    /**
     * 可重定向的 URI 地址
     * 该字段表示允许的重定向 URI 列表。
     */
    private List<String> redirectUris;

    /**
     * 授权类型
     * 该字段表示授权类型列表，参考 `OAuth2GrantTypeEnum` 枚举。
     */
    private List<String> authorizedGrantTypes;

    /**
     * 授权范围
     * 该字段表示允许的授权范围。
     */
    private List<String> scopes;

    /**
     * 自动通过的授权范围
     * 该字段表示无需用户授权即可通过的授权范围。
     */
    private List<String> autoApproveScopes;

    /**
     * 权限
     * 该字段表示应用所需的权限列表。
     */
    private List<String> authorities;

    /**
     * 资源
     * 该字段表示 OAuth2 客户端支持的资源。
     */
    private List<String> resourceIds;

    /**
     * 附加信息
     * 该字段用于保存额外的 JSON 格式的附加信息。
     */
    private String additionalInformation;

    /**
     * 创建时间
     * 该字段表示 OAuth2 客户端的创建时间。
     */
    private LocalDateTime createTime;
}
