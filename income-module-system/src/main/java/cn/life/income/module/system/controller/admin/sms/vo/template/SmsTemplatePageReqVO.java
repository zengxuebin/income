package cn.life.income.module.system.controller.admin.sms.vo.template;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 短信模板分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsTemplatePageReqVO extends PageParam {

    /**
     * 短信签名类型
     * 示例值：1
     */
    private Integer type;

    /**
     * 开启状态
     * 示例值：1
     */
    private Integer status;

    /**
     * 模板编码，模糊匹配
     * 示例值：test_01
     */
    private String code;

    /**
     * 模板内容，模糊匹配
     * 示例值：你好，{name}。你长的太{like}啦！
     */
    private String content;

    /**
     * 短信 API 的模板编号，模糊匹配
     * 示例值：4383920
     */
    private String apiTemplateId;

    /**
     * 短信渠道编号
     * 示例值：10
     */
    private Long channelId;

    /**
     * 创建时间范围
     * 示例值：[2022-01-01 00:00:00, 2022-12-31 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
