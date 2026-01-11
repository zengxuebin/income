package cn.life.income.module.system.controller.admin.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 管理后台 - 登录用户的菜单信息 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthMenuRespVO {

    /**
     * 菜单编号
     * 必须填写
     */
    private Long id;

    /**
     * 父菜单 ID
     * 必须填写
     */
    private Long parentId;

    /**
     * 菜单名称
     * 必须填写
     */
    private String name;

    /**
     * 路由地址
     * 仅菜单类型为菜单或目录时需要传递
     */
    private String path;

    /**
     * 组件路径
     * 仅菜单类型为菜单时需要传递
     */
    private String component;

    /**
     * 组件名
     */
    private String componentName;

    /**
     * 菜单图标
     * 仅菜单类型为菜单或目录时需要传递
     */
    private String icon;

    /**
     * 是否可见
     * 必须填写
     */
    private Boolean visible;

    /**
     * 是否缓存
     * 必须填写
     */
    private Boolean keepAlive;

    /**
     * 是否总是显示
     */
    private Boolean alwaysShow;

    /**
     * 子路由
     */
    private List<AuthMenuRespVO> children;

}
