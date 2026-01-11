package cn.life.income.module.system.controller.admin.dict.vo.type;

import lombok.Data;

/**
 * 管理后台 - 字典类型精简信息 Response VO
 */
@Data
public class DictTypeSimpleRespVO {

    /**
     * 字典类型编号
     * 示例值: 1024
     */
    private Long id;

    /**
     * 字典类型名称
     * 示例值: 芋道
     */
    private String name;

    /**
     * 字典类型
     * 示例值: sys_common_sex
     */
    private String type;

}
