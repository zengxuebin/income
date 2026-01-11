package cn.life.income.module.system.controller.admin.oauth2.vo.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 管理后台 - 访问令牌 Response VO
 * 该类表示返回的访问令牌信息，包括令牌、用户信息、客户端信息等。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2AccessTokenRespVO {

    /**
     * 编号
     * 唯一标识每个访问令牌
     */
    private Long id;

    /**
     * 访问令牌
     * 用户授权后，应用获得的访问令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     * 用于刷新访问令牌，获取新的访问令牌
     */
    private String refreshToken;

    /**
     * 用户编号
     * 唯一标识用户
     */
    private Long userId;

    /**
     * 用户类型
     * 参见 UserTypeEnum 枚举，表示用户所属类型
     */
    private Integer userType;

    /**
     * 客户端编号
     * 唯一标识客户端应用
     */
    private String clientId;

    /**
     * 创建时间
     * 访问令牌的创建时间
     */
    private LocalDateTime createTime;

    /**
     * 过期时间
     * 访问令牌的过期时间
     */
    private LocalDateTime expiresTime;
}
