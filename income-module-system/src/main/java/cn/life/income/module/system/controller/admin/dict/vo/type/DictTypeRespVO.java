package cn.life.income.module.system.controller.admin.dict.vo.type;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 字典类型信息 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class DictTypeRespVO {

    /**
     * 字典类型编号
     * 示例值: 1024
     */
    @ExcelProperty("字典主键")
    private Long id;

    /**
     * 字典名称
     * 示例值: 性别
     */
    @ExcelProperty("字典名称")
    private String name;

    /**
     * 字典类型
     * 示例值: sys_common_sex
     */
    @ExcelProperty("字典类型")
    private String type;

    /**
     * 状态，参见 CommonStatusEnum 枚举类
     * 示例值: 1
     */
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 备注
     * 示例值: 快乐的备注
     */
    private String remark;

    /**
     * 创建时间
     * 示例值: 时间戳格式
     */
    private LocalDateTime createTime;

}
