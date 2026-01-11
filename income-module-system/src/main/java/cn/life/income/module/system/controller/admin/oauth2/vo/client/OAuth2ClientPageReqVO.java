package cn.life.income.module.system.controller.admin.oauth2.vo.client;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 管理后台 - OAuth2 客户端分页请求 VO (Value Object)
 * 用于接收分页查询 OAuth2 客户端请求的参数。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OAuth2ClientPageReqVO extends PageParam {

    /**
     * 应用名
     * 用于进行模糊匹配查询客户端的名称。
     */
    private String name;

    /**
     * 状态
     * 该字段表示查询的 OAuth2 客户端的状态。
     * 状态参考枚举 `CommonStatusEnum`。
     */
    private Integer status;
}
