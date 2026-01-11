package cn.life.income.module.system.controller.admin.dept.vo.dept;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * 管理后台 - 部门列表请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示部门列表查询请求，包括部门名称和状态字段。
 * </p>
 */
@Data
public class DeptListReqVO {

    /**
     * 部门名称，模糊匹配
     * <p>
     * 用于根据部门名称进行模糊查询。
     * </p>
     */
    private String name;

    /**
     * 展示状态
     * <p>
     * 参见 {@link CommonStatusEnum} 枚举类，表示查询的部门的状态。
     * </p>
     */
    private Integer status;

}
