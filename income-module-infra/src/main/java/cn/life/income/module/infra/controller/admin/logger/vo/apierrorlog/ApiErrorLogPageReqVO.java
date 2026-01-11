package cn.life.income.module.infra.controller.admin.logger.vo.apierrorlog;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - API 错误日志分页 Request VO
 */
@Data
public class ApiErrorLogPageReqVO extends PageParam {

    /**
     * 用户编号
     * 例如：666
     */
    private Long userId;

    /**
     * 用户类型
     * 例如：1
     */
    private Integer userType;

    /**
     * 应用名
     * 例如：dashboard
     */
    private String applicationName;

    /**
     * 请求地址
     * 例如：/xx/yy
     */
    private String requestUrl;

    /**
     * 异常发生时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] exceptionTime;

    /**
     * 处理状态
     * 例如：0
     */
    private Integer processStatus;

}