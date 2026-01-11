package cn.life.income.module.system.controller.admin.logger.vo.operatelog;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 操作日志分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示操作日志的分页查询请求，包含了用户编号、操作模块、操作名、操作明细以及操作时间等字段。
 * </p>
 */
@Data
public class OperateLogPageReqVO extends PageParam {

    /**
     * 用户编号
     * <p>
     * 用于指定执行操作的用户编号。
     * </p>
     */
    private Long userId;

    /**
     * 操作模块业务编号
     * <p>
     * 用于指定操作的业务编号，通常代表某个特定模块或功能。
     * </p>
     */
    private Long bizId;

    /**
     * 操作模块
     * <p>
     * 用于指定操作所属的模块名称，支持模糊匹配，如 "订单"。
     * </p>
     */
    private String type;

    /**
     * 操作名
     * <p>
     * 用于指定具体的操作名称，支持模糊匹配，如 "创建订单"。
     * </p>
     */
    private String subType;

    /**
     * 操作明细
     * <p>
     * 用于指定操作的详细描述，支持模糊匹配，如 "修改编号为 1 的用户信息"。
     * </p>
     */
    private String action;

    /**
     * 开始时间
     * <p>
     * 用于查询操作日志的时间范围，格式为 `[yyyy-MM-dd HH:mm:ss, yyyy-MM-dd HH:mm:ss]`。
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
}
