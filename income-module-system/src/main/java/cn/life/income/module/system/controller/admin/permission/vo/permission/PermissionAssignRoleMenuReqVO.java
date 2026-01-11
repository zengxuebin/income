package cn.life.income.module.system.controller.admin.permission.vo.permission;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

/**
 * 管理后台 - 赋予角色菜单 Request VO
 */
@Data
public class PermissionAssignRoleMenuReqVO {

    /**
     * 角色编号
     * 必须填写
     */
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    /**
     * 菜单编号列表
     * 默认为空集合，表示没有菜单
     */
    private Set<Long> menuIds = Collections.emptySet(); // 兜底

}
