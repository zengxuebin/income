package cn.life.income.module.infra.controller.admin.logger.vo.apiaccesslog;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - API 访问日志分页 Request VO
 */
@Data
public class ApiAccessLogPageReqVO extends PageParam {

    /**
     * 用户编号
     * 例如：666
     */
    private Long userId;

    /**
     * 用户类型
     * 例如：2
     */
    private Integer userType;

    /**
     * 应用名
     * 例如：dashboard
     */
    private String applicationName;

    /**
     * 请求地址，模糊匹配
     * 例如：/xxx/yyy
     */
    private String requestUrl;

    /**
     * 开始时间
     * 例如：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] beginTime;

    /**
     * 执行时长，大于等于，单位：毫秒
     * 例如：100
     */
    private Integer duration;

    /**
     * 结果码
     * 例如：0
     */
    private Integer resultCode;

}