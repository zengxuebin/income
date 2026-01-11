package cn.life.income.module.system.controller.admin.user.vo.user;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 用户分页请求 VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPageReqVO extends PageParam {

    /**
     * 用户账号，模糊匹配
     */
    private String username;

    /**
     * 手机号码，模糊匹配
     */
    private String mobile;

    /**
     * 展示状态，参见 CommonStatusEnum 枚举类
     */
    private Integer status;

    /**
     * 创建时间
     * 格式：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    /**
     * 部门编号，同时筛选子部门
     */
    private Long deptId;

    /**
     * 角色编号
     */
    private Long roleId;
}
