package cn.life.income.module.system.controller.admin.dict.vo.data;

import lombok.Data;

/**
 * 管理后台 - 数据字典精简 Response VO
 */
@Data
public class DictDataSimpleRespVO {

    /**
     * 字典类型
     * 示例值: gender
     */
    private String dictType;

    /**
     * 字典键值
     * 示例值: 1
     */
    private String value;

    /**
     * 字典标签
     * 示例值: 男
     */
    private String label;

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

}
