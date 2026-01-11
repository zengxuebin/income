package cn.life.income.module.infra.controller.admin.logger;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import cn.life.income.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import cn.life.income.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import cn.life.income.module.infra.service.logger.ApiAccessLogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - API 访问日志控制器
 */
@RestController
@RequestMapping("/infra/api-access-log")
@Validated
public class ApiAccessLogController {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    /**
     * 获得指定的 API 访问日志
     *
     * @param id API 访问日志的编号
     * @return 返回 API 访问日志信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:api-access-log:query')")
    public CommonResult<ApiAccessLogRespVO> getApiAccessLog(@RequestParam("id") Long id) {
        ApiAccessLogDO apiAccessLog = apiAccessLogService.getApiAccessLog(id);
        return success(BeanUtils.toBean(apiAccessLog, ApiAccessLogRespVO.class));
    }

    /**
     * 获取 API 访问日志分页列表
     *
     * @param pageReqVO API 访问日志分页请求对象
     * @return 返回 API 访问日志分页数据
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:api-access-log:query')")
    public CommonResult<PageResult<ApiAccessLogRespVO>> getApiAccessLogPage(@Valid ApiAccessLogPageReqVO pageReqVO) {
        PageResult<ApiAccessLogDO> pageResult = apiAccessLogService.getApiAccessLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ApiAccessLogRespVO.class));
    }

    /**
     * 导出 API 访问日志到 Excel 文件
     *
     * @param exportReqVO API 访问日志分页请求对象
     * @param response    HTTP 响应对象
     * @throws IOException 导出过程中的异常
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:api-access-log:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportApiAccessLogExcel(@Valid ApiAccessLogPageReqVO exportReqVO,
                                        HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ApiAccessLogDO> list = apiAccessLogService.getApiAccessLogPage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "API 访问日志.xls", "数据", ApiAccessLogRespVO.class,
                BeanUtils.toBean(list, ApiAccessLogRespVO.class));
    }

}
