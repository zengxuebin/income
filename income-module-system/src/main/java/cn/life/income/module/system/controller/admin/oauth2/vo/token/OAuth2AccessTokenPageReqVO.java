package cn.life.income.module.system.controller.admin.oauth2.vo.token;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理后台 - 访问令牌分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示OAuth2访问令牌的分页查询请求，包含了用户编号、用户类型、客户端编号等字段。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2AccessTokenPageReqVO extends PageParam {

    /**
     * 用户编号
     * <p>
     * 用于指定查询某个特定用户的OAuth2访问令牌，必须提供。
     * </p>
     */
    private Long userId;

    /**
     * 用户类型
     * <p>
     * 用于指定查询特定类型用户的OAuth2访问令牌。参见 `UserTypeEnum` 枚举，必须提供。
     * </p>
     */
    private Integer userType;

    /**
     * 客户端编号
     * <p>
     * 用于指定查询某个特定客户端的OAuth2访问令牌，必须提供。
     * </p>
     */
    private String clientId;
}
