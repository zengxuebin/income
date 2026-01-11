package cn.life.income.module.system.controller.admin.dept.vo.post;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 岗位信息 Response VO
 * <p>
 * 该类用于表示岗位的详细信息。
 * </p>
 */
@Data
@ExcelIgnoreUnannotated
public class PostRespVO {

    /**
     * 岗位序号
     * <p>
     * 唯一标识每个岗位。
     * </p>
     */
    @ExcelProperty("岗位序号")
    private Long id;

    /**
     * 岗位名称
     * <p>
     * 如“小土豆”，用于表示岗位的名称。
     * </p>
     */
    @ExcelProperty("岗位名称")
    private String name;

    /**
     * 岗位编码
     * <p>
     * 用于岗位的唯一标识，例如 "income"。
     * </p>
     */
    @ExcelProperty("岗位编码")
    private String code;

    /**
     * 显示顺序
     * <p>
     * 用于排序岗位的显示顺序。
     * </p>
     */
    @ExcelProperty("岗位排序")
    private Integer sort;

    /**
     * 岗位状态
     * <p>
     * 参见 {@link cn.life.income.framework.common.enums.CommonStatusEnum} 枚举类的状态，如启用或禁用。
     * </p>
     */
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 备注
     * <p>
     * 可选字段，用于描述岗位的附加信息。
     * </p>
     */
    private String remark;

    /**
     * 创建时间
     * <p>
     * 记录岗位创建的时间。
     * </p>
     */
    private LocalDateTime createTime;
}
