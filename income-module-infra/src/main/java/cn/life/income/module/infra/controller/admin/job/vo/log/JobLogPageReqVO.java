package cn.life.income.module.infra.controller.admin.job.vo.log;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 定时任务日志分页 Request VO
 */
@Data
public class JobLogPageReqVO extends PageParam {

    /**
     * 任务编号
     */
    private Long jobId;

    /**
     * 处理器的名字，模糊匹配
     */
    private String handlerName;

    /**
     * 开始执行时间
     * <p>
     * 格式：yyyy-MM-dd HH:mm:ss
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginTime;

    /**
     * 结束执行时间
     * <p>
     * 格式：yyyy-MM-dd HH:mm:ss
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    /**
     * 任务状态，参见 JobLogStatusEnum 枚举
     */
    private Integer status;
}
