package cn.life.income.module.system.controller.admin.logger.vo.loginlog;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 登录日志分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示登录日志的分页查询请求，包含了用户 IP、用户名、登录状态、登录时间等字段。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginLogPageReqVO extends PageParam {

    /**
     * 用户 IP
     * <p>
     * 用于模拟匹配用户的 IP 地址，可以用于查询特定 IP 的登录日志。
     * </p>
     */
    private String userIp;

    /**
     * 用户账号
     * <p>
     * 用于模拟匹配用户的用户名，支持模糊查询。
     * </p>
     */
    private String username;

    /**
     * 操作状态
     * <p>
     * 用于表示用户登录的状态，值为 `true` 表示登录成功，`false` 表示登录失败。
     * </p>
     */
    private Boolean status;

    /**
     * 登录时间
     * <p>
     * 用于查询登录日志的时间范围，格式为 `[yyyy-MM-dd HH:mm:ss, yyyy-MM-dd HH:mm:ss]`。
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
}
