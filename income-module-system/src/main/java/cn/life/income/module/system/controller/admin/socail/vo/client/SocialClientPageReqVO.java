package cn.life.income.module.system.controller.admin.socail.vo.client;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 管理后台 - 社交客户端分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于管理后台操作社交客户端的分页查询，包含社交平台类型、客户端信息、状态等筛选条件。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocialClientPageReqVO extends PageParam {

    /**
     * 应用名
     * <p>
     * 用于根据社交客户端的应用名称进行模糊匹配查询。
     * </p>
     */
    private String name;

    /**
     * 社交平台的类型
     * <p>
     * 用于根据社交平台的类型进行查询，例如微信、支付宝等社交平台。
     * </p>
     */
    private Integer socialType;

    /**
     * 用户类型
     * <p>
     * 用于根据用户类型进行查询，指示社交客户端适用的用户类型。
     * </p>
     */
    private Integer userType;

    /**
     * 客户端编号
     * <p>
     * 用于根据社交客户端的编号进行查询。
     * </p>
     */
    private String clientId;

    /**
     * 状态
     * <p>
     * 用于根据社交客户端的状态进行查询，指示客户端是否启用或禁用。
     * </p>
     */
    private Integer status;

}
