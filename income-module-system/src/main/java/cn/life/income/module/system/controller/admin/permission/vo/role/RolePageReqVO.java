package cn.life.income.module.system.controller.admin.permission.vo.role;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 角色分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示管理后台角色分页查询的请求参数，支持根据角色名称、角色标识、状态等条件进行筛选。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageReqVO extends PageParam {

    /**
     * 角色名称，支持模糊匹配
     * <p>
     * 用于根据角色名称进行模糊查询。
     * </p>
     */
    private String name;

    /**
     * 角色标识，支持模糊匹配
     * <p>
     * 用于根据角色标识进行模糊查询。
     * </p>
     */
    private String code;

    /**
     * 展示状态，参见 CommonStatusEnum 枚举类
     * <p>
     * 用于指定角色的展示状态，支持过滤已禁用或已启用的角色。
     * </p>
     */
    private Integer status;

    /**
     * 创建时间范围
     * <p>
     * 用于查询指定时间范围内创建的角色，格式为 `[YYYY-MM-DD HH:mm:ss, YYYY-MM-DD HH:mm:ss]`。
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
