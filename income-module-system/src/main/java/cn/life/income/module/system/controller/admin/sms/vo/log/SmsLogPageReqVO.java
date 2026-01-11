package cn.life.income.module.system.controller.admin.sms.vo.log;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 短信日志分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsLogPageReqVO extends PageParam {

    /**
     * 短信渠道编号
     * 示例值：10
     */
    private Long channelId;

    /**
     * 模板编号
     * 示例值：20
     */
    private Long templateId;

    /**
     * 手机号
     * 示例值：15601691300
     */
    private String mobile;

    /**
     * 发送状态，参见 SmsSendStatusEnum 枚举类
     * 示例值：1
     */
    private Integer sendStatus;

    /**
     * 发送时间
     * 格式：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

    /**
     * 接收状态，参见 SmsReceiveStatusEnum 枚举类
     * 示例值：0
     */
    private Integer receiveStatus;

    /**
     * 接收时间
     * 格式：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiveTime;

}
