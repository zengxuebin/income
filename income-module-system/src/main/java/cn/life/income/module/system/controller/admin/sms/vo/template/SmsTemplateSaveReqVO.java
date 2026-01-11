package cn.life.income.module.system.controller.admin.sms.vo.template;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

/**
 * 管理后台 - 短信模板创建/修改 Request VO
 */
@Data
public class SmsTemplateSaveReqVO {

    /**
     * 编号
     * 示例值：1024
     */
    private Long id;

    /**
     * 短信类型，参见 SmsTemplateTypeEnum 枚举类
     * 示例值：1
     * 必填项
     */
    @NotNull(message = "短信类型不能为空")
    private Integer type;

    /**
     * 开启状态，参见 CommonStatusEnum 枚举类
     * 示例值：1
     * 必填项
     */
    @NotNull(message = "开启状态不能为空")
    private Integer status;

    /**
     * 模板编码
     * 示例值：test_01
     * 必填项
     */
    @NotNull(message = "模板编码不能为空")
    private String code;

    /**
     * 模板名称
     * 示例值：income
     * 必填项
     */
    @NotNull(message = "模板名称不能为空")
    private String name;

    /**
     * 模板内容
     * 示例值：你好，{name}。你长的太{like}啦！
     * 必填项
     */
    @NotNull(message = "模板内容不能为空")
    private String content;

    /**
     * 备注
     * 示例值：哈哈哈
     */
    private String remark;

    /**
     * 短信 API 的模板编号
     * 示例值：4383920
     * 必填项
     */
    @NotNull(message = "短信 API 的模板编号不能为空")
    private String apiTemplateId;

    /**
     * 短信渠道编号
     * 示例值：10
     * 必填项
     */
    @NotNull(message = "短信渠道编号不能为空")
    private Long channelId;

}
