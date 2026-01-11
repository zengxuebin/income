package cn.life.income.module.system.controller.admin.oauth2.vo.open;

import cn.life.income.framework.common.core.KeyValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 管理后台 - 授权页的信息 Response VO
 * 该类表示返回给客户端的授权页信息，包含客户端信息以及授权范围的选中情况。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2OpenAuthorizeInfoRespVO {

    /**
     * 客户端信息
     * 包括客户端的名称和图标等信息
     */
    private Client client;

    /**
     * scope 的选中信息
     * 使用 List 保证有序性，Key 是 scope，Value 为是否选中
     */
    private List<KeyValue<String, Boolean>> scopes;

    /**
     * 客户端信息类
     * 包含应用的基本信息，如应用名称和图标。
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Client {

        /**
         * 应用名
         * 客户端应用的名称
         */
        private String name;

        /**
         * 应用图标
         * 客户端应用的图标 URL
         */
        private String logo;
    }
}
