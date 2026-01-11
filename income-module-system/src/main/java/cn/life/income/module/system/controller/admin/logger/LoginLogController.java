package cn.life.income.module.system.controller.admin.logger;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import cn.life.income.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import cn.life.income.module.system.dal.dataobject.logger.LoginLogDO;
import cn.life.income.module.system.service.logger.LoginLogService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 登录日志
 */
@RestController
@RequestMapping("/system/login-log")
@Validated
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    /**
     * 获得登录日志
     * @param id 登录日志ID
     * @return 登录日志响应
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:login-log:query')")
    public CommonResult<LoginLogRespVO> getLoginLog(Long id) {
        LoginLogDO loginLog = loginLogService.getLoginLog(id);
        return success(BeanUtils.toBean(loginLog, LoginLogRespVO.class));
    }

    /**
     * 获得登录日志分页列表
     * @param pageReqVO 分页请求参数
     * @return 登录日志分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:login-log:query')")
    public CommonResult<PageResult<LoginLogRespVO>> getLoginLogPage(@Valid LoginLogPageReqVO pageReqVO) {
        PageResult<LoginLogDO> pageResult = loginLogService.getLoginLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, LoginLogRespVO.class));
    }

    /**
     * 导出登录日志 Excel
     * @param response HttpServletResponse
     * @param exportReqVO 导出请求参数
     * @throws IOException IO异常
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:login-log:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportLoginLog(HttpServletResponse response, @Valid LoginLogPageReqVO exportReqVO) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<LoginLogDO> list = loginLogService.getLoginLogPage(exportReqVO).getList();
        // 输出
        ExcelUtils.write(response, "登录日志.xls", "数据列表", LoginLogRespVO.class,
                BeanUtils.toBean(list, LoginLogRespVO.class));
    }

}
