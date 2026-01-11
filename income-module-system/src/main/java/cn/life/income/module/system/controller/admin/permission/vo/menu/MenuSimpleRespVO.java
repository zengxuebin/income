package cn.life.income.module.system.controller.admin.permission.vo.menu;

import lombok.Data;

/**
 * 管理后台 - 菜单精简信息 Response VO
 */
@Data
public class MenuSimpleRespVO {

    /**
     * 菜单编号
     * 必须填写
     */
    private Long id;

    /**
     * 菜单名称
     * 必须填写
     */
    private String name;

    /**
     * 父菜单 ID
     * 必须填写
     */
    private Long parentId;

    /**
     * 菜单类型，参见 MenuTypeEnum 枚举类
     * 必须填写
     */
    private Integer type;

}
