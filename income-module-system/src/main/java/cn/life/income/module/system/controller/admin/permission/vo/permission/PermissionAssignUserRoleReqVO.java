package cn.life.income.module.system.controller.admin.permission.vo.permission;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

/**
 * 管理后台 - 赋予用户角色 Request VO
 */
@Data
public class PermissionAssignUserRoleReqVO {

    /**
     * 用户编号
     * 必须填写
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    /**
     * 角色编号列表
     * 默认为空集合，表示没有指定角色
     */
    private Set<Long> roleIds = Collections.emptySet(); // 兜底

}
