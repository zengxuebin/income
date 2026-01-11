package cn.life.income.module.infra.controller.admin.logger;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import cn.life.income.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import cn.life.income.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import cn.life.income.module.infra.service.logger.ApiErrorLogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@RestController
@RequestMapping("/infra/api-error-log")
@Validated
public class ApiErrorLogController {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    /**
     * 更新 API 错误日志的状态
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:update-status')")
    public CommonResult<Boolean> updateApiErrorLogProcess(@RequestParam("id") Long id,
                                                          @RequestParam("processStatus") Integer processStatus) {
        apiErrorLogService.updateApiErrorLogProcess(id, processStatus, getLoginUserId());
        return success(true);
    }

    /**
     * 获得 API 错误日志
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:query')")
    public CommonResult<ApiErrorLogRespVO> getApiErrorLog(@RequestParam("id") Long id) {
        ApiErrorLogDO apiErrorLog = apiErrorLogService.getApiErrorLog(id);
        return success(BeanUtils.toBean(apiErrorLog, ApiErrorLogRespVO.class));
    }

    /**
     * 获得 API 错误日志分页
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:query')")
    public CommonResult<PageResult<ApiErrorLogRespVO>> getApiErrorLogPage(@Valid ApiErrorLogPageReqVO pageReqVO) {
        PageResult<ApiErrorLogDO> pageResult = apiErrorLogService.getApiErrorLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ApiErrorLogRespVO.class));
    }

    /**
     * 导出 API 错误日志 Excel
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportApiErrorLogExcel(@Valid ApiErrorLogPageReqVO exportReqVO,
                                       HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ApiErrorLogDO> list = apiErrorLogService.getApiErrorLogPage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "API 错误日志.xls", "数据", ApiErrorLogRespVO.class,
                BeanUtils.toBean(list, ApiErrorLogRespVO.class));
    }

}
