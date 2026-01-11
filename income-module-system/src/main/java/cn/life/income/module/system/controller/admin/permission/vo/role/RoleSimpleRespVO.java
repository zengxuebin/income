package cn.life.income.module.system.controller.admin.permission.vo.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 角色精简信息 Response VO
 * 仅包含角色的基本信息，用于角色选择等场景
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleSimpleRespVO {

    /**
     * 角色编号
     * 唯一标识角色
     */
    private Long id;

    /**
     * 角色名称
     * 显示为角色的名称
     */
    private String name;
}
