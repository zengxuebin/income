package cn.life.income.module.system.controller.admin.permission.vo.role;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 管理后台 - 角色信息 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class RoleRespVO {

    /**
     * 角色编号
     * 显示为 Excel 表格中的“角色序号”
     */
    @ExcelProperty("角色序号")
    private Long id;

    /**
     * 角色名称
     * 显示为 Excel 表格中的“角色名称”
     */
    @ExcelProperty("角色名称")
    private String name;

    /**
     * 角色标志
     * 必须填写
     * 显示为 Excel 表格中的“角色标志”
     */
    @NotBlank(message = "角色标志不能为空")
    @ExcelProperty("角色标志")
    private String code;

    /**
     * 显示顺序
     * 显示为 Excel 表格中的“角色排序”
     */
    @ExcelProperty("角色排序")
    private Integer sort;

    /**
     * 角色状态，参见 CommonStatusEnum 枚举类
     * 显示为 Excel 表格中的“角色状态”
     */
    @ExcelProperty(value = "角色状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 角色类型，参见 RoleTypeEnum 枚举类
     */
    private Integer type;

    /**
     * 备注
     * 例如：我是一个角色
     */
    private String remark;

    /**
     * 数据范围，参见 DataScopeEnum 枚举类
     * 显示为 Excel 表格中的“数据范围”
     */
    @ExcelProperty(value = "数据范围", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.DATA_SCOPE)
    private Integer dataScope;

    /**
     * 数据范围(指定部门数组)
     * 可为空
     */
    private Set<Long> dataScopeDeptIds;

    /**
     * 创建时间
     * 时间戳格式
     */
    private LocalDateTime createTime;

}
