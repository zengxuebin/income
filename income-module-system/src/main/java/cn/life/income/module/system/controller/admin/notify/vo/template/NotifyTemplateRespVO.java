package cn.life.income.module.system.controller.admin.notify.vo.template;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - 站内信模板响应 VO
 * 用于返回站内信模板的详细信息，包括模板的基本信息、参数、状态等。
 */
@Data
public class NotifyTemplateRespVO {

    /**
     * 模板ID
     * 必填，标识模板的唯一ID
     */
    private Long id;

    /**
     * 模板名称
     * 必填，表示模板的名称
     */
    private String name;

    /**
     * 模板编码
     * 必填，模板的唯一编码
     */
    private String code;

    /**
     * 模板类型，参照 system_notify_template_type 字典
     * 必填，表示模板的类型
     */
    private Integer type;

    /**
     * 发送人名称
     * 必填，表示模板发送人的名称
     */
    private String nickname;

    /**
     * 模板内容
     * 必填，表示模板的实际内容
     */
    private String content;

    /**
     * 模板参数列表
     * 可选，包含模板中需要替换的参数（如名称、编码等）
     */
    private List<String> params;

    /**
     * 模板状态，参见 CommonStatusEnum 枚举
     * 必填，表示模板的当前状态（启用或禁用）
     */
    private Integer status;

    /**
     * 模板备注
     * 可选，模板的附加说明或备注信息
     */
    private String remark;

    /**
     * 创建时间
     * 必填，表示模板的创建时间
     */
    private LocalDateTime createTime;
}
