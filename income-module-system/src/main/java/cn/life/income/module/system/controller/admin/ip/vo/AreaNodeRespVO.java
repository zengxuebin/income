package cn.life.income.module.system.controller.admin.ip.vo;

import lombok.Data;

import java.util.List;

/**
 * 管理后台 - 地区节点 Response VO
 */
@Data
public class AreaNodeRespVO {

    /**
     * 编号
     * 示例值: 110000
     */
    private Integer id;

    /**
     * 名字
     * 示例值: 北京
     */
    private String name;

    /**
     * 子节点
     */
    private List<AreaNodeRespVO> children;

}
