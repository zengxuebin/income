package cn.life.income.module.infra.controller.admin.job.vo.job;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;

/**
 * 管理后台 - 定时任务分页 Request VO
 */
@Data
public class JobPageReqVO extends PageParam {

    /**
     * 任务名称，模糊匹配
     *
     * 示例：测试任务
     */
    private String name;

    /**
     * 任务状态，参见 JobStatusEnum 枚举
     *
     * 示例：1
     */
    private Integer status;

    /**
     * 处理器的名字，模糊匹配
     *
     * 示例：sysUserSessionTimeoutJob
     */
    private String handlerName;

}
