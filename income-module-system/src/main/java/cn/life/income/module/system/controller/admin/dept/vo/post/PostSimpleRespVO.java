package cn.life.income.module.system.controller.admin.dept.vo.post;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 管理后台 - 岗位信息的精简 Response VO
 * <p>
 * 该类用于返回岗位的精简信息，主要用于下拉选项或快速展示。
 * </p>
 */
@Data
public class PostSimpleRespVO {

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
}
