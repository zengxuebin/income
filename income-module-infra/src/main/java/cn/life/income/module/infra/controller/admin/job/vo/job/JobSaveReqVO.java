package cn.life.income.module.infra.controller.admin.job.vo.job;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 管理后台 - 定时任务创建/修改 Request VO
 */
@Data
public class JobSaveReqVO {

    /**
     * 任务编号
     *
     * 示例：1024
     */
    private Long id;

    /**
     * 任务名称
     *
     * 必填项，不能为空。
     * 示例：测试任务
     */
    @NotEmpty(message = "任务名称不能为空")
    private String name;

    /**
     * 处理器的名字
     *
     * 必填项，不能为空。
     * 示例：sysUserSessionTimeoutJob
     */
    @NotEmpty(message = "处理器的名字不能为空")
    private String handlerName;

    /**
     * 处理器的参数
     *
     * 示例：income
     */
    private String handlerParam;

    /**
     * CRON 表达式
     *
     * 必填项，不能为空。
     * 示例：0/10 * * * * ? *
     */
    @NotEmpty(message = "CRON 表达式不能为空")
    private String cronExpression;

    /**
     * 重试次数
     *
     * 必填项，不能为空。
     * 示例：3
     */
    @NotNull(message = "重试次数不能为空")
    private Integer retryCount;

    /**
     * 重试间隔
     *
     * 必填项，不能为空。
     * 示例：1000
     */
    @NotNull(message = "重试间隔不能为空")
    private Integer retryInterval;

    /**
     * 监控超时时间
     *
     * 示例：1000
     */
    private Integer monitorTimeout;

}
