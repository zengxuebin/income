package cn.life.income.module.system.controller.admin.oauth2.vo.open;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 【开放接口】访问令牌 Response VO
 * 该类表示开放接口返回的访问令牌信息，包含访问令牌、刷新令牌、令牌类型、过期时间等。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2OpenAccessTokenRespVO {

    /**
     * 访问令牌
     * 用于授权客户端访问受保护资源
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 刷新令牌
     * 用于获取新的访问令牌，避免重新认证
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 令牌类型
     * 通常是 "bearer"
     */
    @JsonProperty("token_type")
    private String tokenType;

    /**
     * 过期时间，单位：秒
     * 指定访问令牌的有效期
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 授权范围
     * 如果有多个授权范围，则使用空格分隔
     */
    private String scope;
}
