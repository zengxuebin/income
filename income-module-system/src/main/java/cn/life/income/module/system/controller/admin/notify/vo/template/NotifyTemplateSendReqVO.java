package cn.life.income.module.system.controller.admin.notify.vo.template;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

/**
 * 管理后台 - 站内信模板的发送请求 VO
 * 用于发送站内信时的请求参数，包括用户ID、用户类型、模板编码和模板参数等。
 */
@Data
public class NotifyTemplateSendReqVO {

    /**
     * 用户ID
     * 必填，表示接收站内信的用户的唯一标识。
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 用户类型
     * 必填，表示接收站内信的用户类型（如管理员、会员等）。
     */
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * 模板编码
     * 必填，表示所使用的站内信模板的唯一编码。
     */
    @NotEmpty(message = "模板编码不能为空")
    private String templateCode;

    /**
     * 模板参数
     * 可选，表示用于替换模板中占位符的参数，如 {username} 等。
     */
    private Map<String, Object> templateParams;
}
