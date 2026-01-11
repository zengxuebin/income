package cn.life.income.module.infra.controller.admin.job.vo.job;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.infra.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 定时任务 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class JobRespVO {

    /**
     * 任务编号
     *
     * 必填项，不能为空。
     * 示例：1024
     */
    @ExcelProperty("任务编号")
    private Long id;

    /**
     * 任务名称
     *
     * 必填项，不能为空。
     * 示例：测试任务
     */
    @ExcelProperty("任务名称")
    private String name;

    /**
     * 任务状态
     *
     * 必填项，不能为空。
     * 示例：1
     * 使用字典类型转换器将数字转换为任务状态描述。
     */
    @ExcelProperty(value = "任务状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.JOB_STATUS)
    private Integer status;

    /**
     * 处理器的名字
     *
     * 必填项，不能为空。
     * 示例：sysUserSessionTimeoutJob
     */
    @ExcelProperty("处理器的名字")
    private String handlerName;

    /**
     * 处理器的参数
     *
     * 示例：income
     */
    @ExcelProperty("处理器的参数")
    private String handlerParam;

    /**
     * CRON 表达式
     *
     * 必填项，不能为空。
     * 示例：0/10 * * * * ? *
     */
    @ExcelProperty("CRON 表达式")
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
     * 示例：1000
     */
    private Integer retryInterval;

    /**
     * 监控超时时间
     *
     * 示例：1000
     */
    @ExcelProperty("监控超时时间")
    private Integer monitorTimeout;

    /**
     * 创建时间
     *
     * 必填项，不能为空。
     */
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
