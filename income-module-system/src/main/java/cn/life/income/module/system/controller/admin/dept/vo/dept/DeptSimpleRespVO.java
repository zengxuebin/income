package cn.life.income.module.system.controller.admin.dept.vo.dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 部门精简信息 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptSimpleRespVO {

    /**
     * 部门编号
     * 必填字段
     */
    private Long id;

    /**
     * 部门名称
     * 必填字段
     */
    private String name;

    /**
     * 父部门 ID
     * 必填字段
     */
    private Long parentId;

}
