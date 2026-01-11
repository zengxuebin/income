package cn.life.income.module.system.controller.app.tenant.vo;

import lombok.Data;

/**
 * 用户 App - 租户 Response VO
 */
@Data
public class AppTenantRespVO {

    /**
     * 租户编号
     */
    private Long id;

    /**
     * 租户名
     */
    private String name;

}
