package cn.life.income.module.system.controller.admin.sms.vo.channel;

import cn.life.income.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 短信渠道分页请求对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsChannelPageReqVO extends PageParam {

    /**
     * 任务状态
     *
     * 表示要查询的短信渠道任务的状态
     */
    private Integer status;

    /**
     * 短信签名，支持模糊匹配
     *
     * 用于根据短信签名进行模糊查询
     */
    private String signature;

    /**
     * 创建时间区间
     *
     * 用于查询创建时间在指定区间内的短信渠道
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
