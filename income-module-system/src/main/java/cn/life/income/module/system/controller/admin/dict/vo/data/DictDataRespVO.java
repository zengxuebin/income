package cn.life.income.module.system.controller.admin.dict.vo.data;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 字典数据信息 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class DictDataRespVO {

    /**
     * 字典数据编号
     * 示例值: 1024
     */
    @ExcelProperty("字典编码")
    private Long id;

    /**
     * 显示顺序
     * 示例值: 1024
     */
    @ExcelProperty("字典排序")
    private Integer sort;

    /**
     * 字典标签
     * 示例值: 芋道
     */
    @ExcelProperty("字典标签")
    private String label;

    /**
     * 字典值
     * 示例值: iocoder
     */
    @ExcelProperty("字典键值")
    private String value;

    /**
     * 字典类型
     * 示例值: sys_common_sex
     */
    @ExcelProperty("字典类型")
    private String dictType;

    /**
     * 状态, 见 CommonStatusEnum 枚举
     * 示例值: 1
     */
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 颜色类型，default、primary、success、info、warning、danger
     * 示例值: default
     */
    private String colorType;

    /**
     * css 样式
     * 示例值: btn-visible
     */
    private String cssClass;

    /**
     * 备注
     * 示例值: 我是一个角色
     */
    private String remark;

    /**
     * 创建时间
     * 示例值: 时间戳格式
     */
    private LocalDateTime createTime;
}
