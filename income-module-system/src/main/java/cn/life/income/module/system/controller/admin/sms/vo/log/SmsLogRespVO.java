package cn.life.income.module.system.controller.admin.sms.vo.log;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.framework.excel.core.convert.JsonConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 管理后台 - 短信日志 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class SmsLogRespVO {

    /**
     * 编号
     * 示例值：1024
     */
    @ExcelProperty("编号")
    private Long id;

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
    @ExcelProperty("短信渠道编码")
    private String channelCode;

    /**
     * 模板编号
     * 示例值：20
     */
    @ExcelProperty("模板编号")
    private Long templateId;

    /**
     * 模板编码
     * 示例值：test-01
     */
    @ExcelProperty("模板编码")
    private String templateCode;

    /**
     * 短信类型
     * 示例值：1
     * 转换字典类型：参见 DictTypeConstants.SMS_TEMPLATE_TYPE
     */
    @ExcelProperty(value = "短信类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_TEMPLATE_TYPE)
    private Integer templateType;

    /**
     * 短信内容
     * 示例值：你好，你的验证码是 1024
     */
    @ExcelProperty("短信内容")
    private String templateContent;

    /**
     * 短信参数
     * 示例值：name,code
     * 转换格式：JSON
     */
    @ExcelProperty(value = "短信参数", converter = JsonConvert.class)
    private Map<String, Object> templateParams;

    /**
     * 短信 API 的模板编号
     * 示例值：SMS_207945135
     */
    @ExcelProperty("短信 API 的模板编号")
    private String apiTemplateId;

    /**
     * 手机号
     * 示例值：15601691300
     */
    @ExcelProperty("手机号")
    private String mobile;

    /**
     * 用户编号
     * 示例值：10
     */
    @ExcelProperty("用户编号")
    private Long userId;

    /**
     * 用户类型
     * 示例值：1
     * 转换字典类型：参见 DictTypeConstants.USER_TYPE
     */
    @ExcelProperty(value = "用户类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    /**
     * 发送状态
     * 示例值：1
     * 转换字典类型：参见 DictTypeConstants.SMS_SEND_STATUS
     */
    @ExcelProperty(value = "发送状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_SEND_STATUS)
    private Integer sendStatus;

    /**
     * 发送时间
     */
    @ExcelProperty("发送时间")
    private LocalDateTime sendTime;

    /**
     * 短信 API 发送结果的编码
     * 示例值：SUCCESS
     */
    @ExcelProperty("短信 API 发送结果的编码")
    private String apiSendCode;

    /**
     * 短信 API 发送失败的提示
     * 示例值：成功
     */
    @ExcelProperty("短信 API 发送失败的提示")
    private String apiSendMsg;

    /**
     * 短信 API 发送返回的唯一请求 ID
     * 示例值：3837C6D3-B96F-428C-BBB2-86135D4B5B99
     */
    @ExcelProperty("短信 API 发送返回的唯一请求 ID")
    private String apiRequestId;

    /**
     * 短信 API 发送返回的序号
     * 示例值：62923244790
     */
    @ExcelProperty("短信 API 发送返回的序号")
    private String apiSerialNo;

    /**
     * 接收状态
     * 示例值：0
     * 转换字典类型：参见 DictTypeConstants.SMS_RECEIVE_STATUS
     */
    @ExcelProperty(value = "接收状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.SMS_RECEIVE_STATUS)
    private Integer receiveStatus;

    /**
     * 接收时间
     */
    @ExcelProperty("接收时间")
    private LocalDateTime receiveTime;

    /**
     * API 接收结果的编码
     * 示例值：DELIVRD
     */
    @ExcelProperty("API 接收结果的编码")
    private String apiReceiveCode;

    /**
     * API 接收结果的说明
     * 示例值：用户接收成功
     */
    @ExcelProperty("API 接收结果的说明")
    private String apiReceiveMsg;

    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
