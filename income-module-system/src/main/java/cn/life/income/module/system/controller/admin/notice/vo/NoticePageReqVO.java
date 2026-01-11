package cn.life.income.module.system.controller.admin.notice.vo;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理后台 - 通知公告分页请求 VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticePageReqVO extends PageParam {

    /**
     * 通知公告名称，模糊匹配
     */
    private String title;

    /**
     * 展示状态，参见 CommonStatusEnum 枚举类
     */
    private Integer status;

}
