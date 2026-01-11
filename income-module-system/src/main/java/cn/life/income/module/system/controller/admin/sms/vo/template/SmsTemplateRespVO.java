package cn.life.income.module.system.controller.admin.sms.vo.template;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - 短信模板 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class SmsTemplateRespVO {

    /**
     * 编号
     * 示例值：1024
     */
    @ExcelProperty("编号")
    private Long id;

    /**
     * 短信类型，参见 SmsTemplateTypeEnum 枚举类
     * 示例值：1
     */
    @ExcelProperty(value = "短信签名", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_TEMPLATE_TYPE)
    private Integer type;

    /**
     * 开启状态，参见 CommonStatusEnum 枚举类
     * 示例值：1
     */
    @ExcelProperty(value = "开启状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 模板编码
     * 示例值：test_01
     */
    @ExcelProperty("模板编码")
    private String code;

    /**
     * 模板名称
     * 示例值：income
     */
    @ExcelProperty("模板名称")
    private String name;

    /**
     * 模板内容
     * 示例值：你好，{name}。你长的太{like}啦！
     */
    @ExcelProperty("模板内容")
    private String content;

    /**
     * 参数数组
     * 示例值：name,code
     */
    private List<String> params;

    /**
     * 备注
     * 示例值：哈哈哈
     */
    @ExcelProperty("备注")
    private String remark;

    /**
     * 短信 API 的模板编号
     * 示例值：4383920
     */
    @ExcelProperty("短信 API 的模板编号")
    private String apiTemplateId;

    /**
     * 短信渠道编号
     * 示例值：10
     */
    @ExcelProperty("短信渠道编号")
    private Long channelId;

    /**
     * 短信渠道编码
     * 示例值：ALIYUN
     */
    @ExcelProperty(value = "短信渠道编码", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_CHANNEL_CODE)
    private String channelCode;

    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
