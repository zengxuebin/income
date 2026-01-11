package cn.life.income.module.system.controller.admin.permission.vo.permission;

import cn.life.income.framework.common.validation.InEnum;
import cn.life.income.module.system.enums.permission.DataScopeEnum;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

/**
 * 管理后台 - 赋予角色数据权限 Request VO
 */
@Data
public class PermissionAssignRoleDataScopeReqVO {

    /**
     * 角色编号
     * 必须填写
     */
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    /**
     * 数据范围，参见 DataScopeEnum 枚举类
     * 必须填写
     */
    @NotNull(message = "数据范围不能为空")
    @InEnum(value = DataScopeEnum.class, message = "数据范围必须是 {value}")
    private Integer dataScope;

    /**
     * 部门编号列表，只有范围类型为 DEPT_CUSTOM 时，该字段才需要
     * 默认为空集合，表示没有指定部门
     */
    private Set<Long> dataScopeDeptIds = Collections.emptySet(); // 兜底

}
