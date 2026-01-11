package cn.life.income.module.infra.controller.admin.job;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.framework.quartz.core.util.CronUtils;
import cn.life.income.module.infra.controller.admin.job.vo.job.JobPageReqVO;
import cn.life.income.module.infra.controller.admin.job.vo.job.JobRespVO;
import cn.life.income.module.infra.controller.admin.job.vo.job.JobSaveReqVO;
import cn.life.income.module.infra.dal.dataobject.job.JobDO;
import cn.life.income.module.infra.service.job.JobService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.quartz.SchedulerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 定时任务 Controller
 */
@RestController
@RequestMapping("/infra/job")
@Validated
public class JobController {

    @Resource
    private JobService jobService;

    /**
     * 创建定时任务
     *
     * @param createReqVO 创建定时任务的请求对象
     * @return 创建结果，返回定时任务 ID
     * @throws SchedulerException 调度异常
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:job:create')")
    public CommonResult<Long> createJob(@Valid @RequestBody JobSaveReqVO createReqVO) throws SchedulerException {
        return success(jobService.createJob(createReqVO));
    }

    /**
     * 更新定时任务
     *
     * @param updateReqVO 更新定时任务的请求对象
     * @return 更新结果
     * @throws SchedulerException 调度异常
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:job:update')")
    public CommonResult<Boolean> updateJob(@Valid @RequestBody JobSaveReqVO updateReqVO) throws SchedulerException {
        jobService.updateJob(updateReqVO);
        return success(true);
    }

    /**
     * 更新定时任务的状态
     *
     * @param id     定时任务的唯一编号
     * @param status 定时任务的状态
     * @return 更新结果
     * @throws SchedulerException 调度异常
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('infra:job:update')")
    public CommonResult<Boolean> updateJobStatus(@RequestParam(value = "id") Long id, @RequestParam("status") Integer status)
            throws SchedulerException {
        jobService.updateJobStatus(id, status);
        return success(true);
    }

    /**
     * 删除定时任务
     *
     * @param id 定时任务的唯一编号
     * @return 删除结果
     * @throws SchedulerException 调度异常
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:job:delete')")
    public CommonResult<Boolean> deleteJob(@RequestParam("id") Long id) throws SchedulerException {
        jobService.deleteJob(id);
        return success(true);
    }

    /**
     * 批量删除定时任务
     *
     * @param ids 定时任务的唯一编号列表
     * @return 批量删除结果
     * @throws SchedulerException 调度异常
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('infra:job:delete')")
    public CommonResult<Boolean> deleteJobList(@RequestParam("ids") List<Long> ids) throws SchedulerException {
        jobService.deleteJobList(ids);
        return success(true);
    }

    /**
     * 触发定时任务
     *
     * @param id 定时任务的唯一编号
     * @return 触发结果
     * @throws SchedulerException 调度异常
     */
    @PutMapping("/trigger")
    @PreAuthorize("@ss.hasPermission('infra:job:trigger')")
    public CommonResult<Boolean> triggerJob(@RequestParam("id") Long id) throws SchedulerException {
        jobService.triggerJob(id);
        return success(true);
    }

    /**
     * 同步定时任务
     *
     * @return 同步结果
     * @throws SchedulerException 调度异常
     */
    @PostMapping("/sync")
    @PreAuthorize("@ss.hasPermission('infra:job:create')")
    public CommonResult<Boolean> syncJob() throws SchedulerException {
        jobService.syncJob();
        return success(true);
    }

    /**
     * 获取定时任务信息
     *
     * @param id 定时任务的唯一编号
     * @return 定时任务信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<JobRespVO> getJob(@RequestParam("id") Long id) {
        JobDO job = jobService.getJob(id);
        return success(BeanUtils.toBean(job, JobRespVO.class));
    }

    /**
     * 获取定时任务分页
     *
     * @param pageVO 定时任务分页请求对象
     * @return 定时任务分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<PageResult<JobRespVO>> getJobPage(@Valid JobPageReqVO pageVO) {
        PageResult<JobDO> pageResult = jobService.getJobPage(pageVO);
        return success(BeanUtils.toBean(pageResult, JobRespVO.class));
    }

    /**
     * 导出定时任务 Excel
     *
     * @param exportReqVO 导出请求对象
     * @param response    HTTP 响应
     * @throws IOException 导出过程中异常
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:job:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportJobExcel(@Valid JobPageReqVO exportReqVO,
                               HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<JobDO> list = jobService.getJobPage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "定时任务.xls", "数据", JobRespVO.class,
                BeanUtils.toBean(list, JobRespVO.class));
    }

    /**
     * 获取定时任务的下 n 次执行时间
     *
     * @param id    定时任务的唯一编号
     * @param count 次数，默认为 5 次
     * @return 定时任务的下次执行时间列表
     */
    @GetMapping("/get_next_times")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<List<LocalDateTime>> getJobNextTimes(
            @RequestParam("id") Long id,
            @RequestParam(value = "count", required = false, defaultValue = "5") Integer count) {
        JobDO job = jobService.getJob(id);
        if (job == null) {
            return success(Collections.emptyList());
        }
        return success(CronUtils.getNextTimes(job.getCronExpression(), count));
    }

}
