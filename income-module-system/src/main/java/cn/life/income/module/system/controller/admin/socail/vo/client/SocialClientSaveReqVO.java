package cn.life.income.module.system.controller.admin.socail.vo.client;

import cn.hutool.core.util.StrUtil;
import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.enums.UserTypeEnum;
import cn.life.income.framework.common.validation.InEnum;
import cn.life.income.module.system.enums.social.SocialTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 * 管理后台 - 社交客户端创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于管理后台操作社交客户端的创建与修改，包含社交平台类型、客户端信息、授权信息等。
 * </p>
 */
@Data
public class SocialClientSaveReqVO {

    /**
     * 编号
     * <p>
     * 用于标识社交客户端的唯一 ID。
     * </p>
     */
    private Long id;

    /**
     * 应用名
     * <p>
     * 需要指定该社交客户端所属的应用名称。
     * </p>
     */
    @NotNull(message = "应用名不能为空")
    private String name;

    /**
     * 社交平台的类型
     * <p>
     * 用于指定该客户端所属的社交平台类型，例如微信、支付宝等。
     * </p>
     */
    @NotNull(message = "社交平台的类型不能为空")
    @InEnum(SocialTypeEnum.class)
    private Integer socialType;

    /**
     * 用户类型
     * <p>
     * 用于指定该社交客户端适用的用户类型，例如管理员、普通用户等。
     * </p>
     */
    @NotNull(message = "用户类型不能为空")
    @InEnum(UserTypeEnum.class)
    private Integer userType;

    /**
     * 客户端编号
     * <p>
     * 用于指定客户端的唯一标识符。
     * </p>
     */
    @NotNull(message = "客户端编号不能为空")
    private String clientId;

    /**
     * 客户端密钥
     * <p>
     * 用于提供客户端的安全认证密钥。
     * </p>
     */
    @NotNull(message = "客户端密钥不能为空")
    private String clientSecret;

    /**
     * 授权方的网页应用编号
     * <p>
     * 在某些社交平台上，客户端可能需要指定授权方的网页应用编号。
     * </p>
     */
    private String agentId;

    /**
     * 公钥
     * <p>
     * 在某些情况下，社交平台要求提供公钥，例如支付宝。
     * </p>
     */
    private String publicKey;

    /**
     * 状态
     * <p>
     * 用于指定该客户端的当前状态，是否可用。
     * </p>
     */
    @NotNull(message = "状态不能为空")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    /**
     * 校验 agentId 是否有效
     * <p>
     * 如果社交平台类型是企业微信，则必须填写 agentId 属性。
     * </p>
     *
     * @return true 如果 agentId 有效，否则返回 false
     */
    @AssertTrue(message = "agentId 不能为空")
    @JsonIgnore
    public boolean isAgentIdValid() {
        // 如果是企业微信，必须填写 agentId 属性
        return !Objects.equals(socialType, SocialTypeEnum.WECHAT_ENTERPRISE.getType())
                || !StrUtil.isEmpty(agentId);
    }

    /**
     * 校验 publicKey 是否有效
     * <p>
     * 如果社交平台类型是支付宝小程序，则必须填写 publicKey 属性。
     * </p>
     *
     * @return true 如果 publicKey 有效，否则返回 false
     */
    @AssertTrue(message = "publicKey 不能为空")
    @JsonIgnore
    public boolean isPublicKeyValid() {
        // 如果是支付宝，必须填写 publicKey 属性
        return !Objects.equals(socialType, SocialTypeEnum.ALIPAY_MINI_PROGRAM.getType())
                || !StrUtil.isEmpty(publicKey);
    }

}
