package cn.life.income.module.system.controller.admin.notify.vo.template;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.validation.InEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 管理后台 - 站内信模版创建/修改请求 VO
 * 用于创建和修改站内信模板时的请求参数
 */
@Data
public class NotifyTemplateSaveReqVO {

    /**
     * 模板ID，编辑时传入
     */
    private Long id;

    /**
     * 模板名称
     * 必填，不能为空
     */
    @NotEmpty(message = "模板名称不能为空")
    private String name;

    /**
     * 模板编码
     * 必填，不能为空
     */
    @NotNull(message = "模板编码不能为空")
    private String code;

    /**
     * 模板类型，参照 system_notify_template_type 字典
     * 必填，不能为空
     */
    @NotNull(message = "模板类型不能为空")
    private Integer type;

    /**
     * 发送人名称
     * 必填，不能为空
     */
    @NotEmpty(message = "发送人名称不能为空")
    private String nickname;

    /**
     * 模板内容
     * 必填，不能为空
     */
    @NotEmpty(message = "模板内容不能为空")
    private String content;

    /**
     * 模板状态，参见 CommonStatusEnum 枚举
     * 必填，不能为空
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

    /**
     * 模板备注
     * 非必填，模板的附加说明
     */
    private String remark;
}
