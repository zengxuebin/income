package cn.life.income.module.system.controller.admin.sms.vo.channel;

import lombok.Data;

/**
 * 管理后台 - 短信渠道精简 Response VO
 */
@Data
public class SmsChannelSimpleRespVO {

    /**
     * 编号
     * 必填字段，示例值：1024
     */
    private Long id;

    /**
     * 短信签名
     * 必填字段，示例值：芋道源码
     */
    private String signature;

    /**
     * 渠道编码，参见 SmsChannelEnum 枚举类
     * 必填字段，示例值：YUN_PIAN
     */
    private String code;

}
