package cn.life.income.module.system.controller.admin.tenant;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.framework.tenant.core.aop.TenantIgnore;
import cn.life.income.module.system.controller.admin.tenant.vo.tenant.TenantPageReqVO;
import cn.life.income.module.system.controller.admin.tenant.vo.tenant.TenantRespVO;
import cn.life.income.module.system.controller.admin.tenant.vo.tenant.TenantSaveReqVO;
import cn.life.income.module.system.dal.dataobject.tenant.TenantDO;
import cn.life.income.module.system.service.tenant.TenantService;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.common.util.collection.CollectionUtils.convertList;

/**
 * 管理后台 - 租户控制器
 */
@RestController
@RequestMapping("/system/tenant")
public class TenantController {

    @Resource
    private TenantService tenantService;

    /**
     * 使用租户名，获得租户编号
     * 登录界面，根据用户的租户名，获得租户编号
     * @param name 租户名
     * @return 租户编号
     */
    @GetMapping("/get-id-by-name")
    @PermitAll
    @TenantIgnore
    public CommonResult<Long> getTenantIdByName(@RequestParam("name") String name) {
        TenantDO tenant = tenantService.getTenantByName(name);
        return success(tenant != null ? tenant.getId() : null);
    }

    /**
     * 获取租户精简信息列表
     * 只包含被开启的租户，用于首页功能的选择租户选项
     * @return 租户精简信息列表
     */
    @GetMapping({ "simple-list" })
    @PermitAll
    @TenantIgnore
    public CommonResult<List<TenantRespVO>> getTenantSimpleList() {
        List<TenantDO> list = tenantService.getTenantListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, tenantDO -> new TenantRespVO().setId(tenantDO.getId()).setName(tenantDO.getName())));
    }

    /**
     * 使用域名，获得租户信息
     * 登录界面，根据用户的域名，获得租户信息
     * @param website 域名
     * @return 租户信息
     */
    @GetMapping("/get-by-website")
    @PermitAll
    @TenantIgnore
    public CommonResult<TenantRespVO> getTenantByWebsite(@RequestParam("website") String website) {
        TenantDO tenant = tenantService.getTenantByWebsite(website);
        if (tenant == null || CommonStatusEnum.isDisable(tenant.getStatus())) {
            return success(null);
        }
        return success(new TenantRespVO().setId(tenant.getId()).setName(tenant.getName()));
    }

    /**
     * 创建租户
     * @param createReqVO 租户创建请求对象
     * @return 创建成功后的租户编号
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:tenant:create')")
    public CommonResult<Long> createTenant(@Valid @RequestBody TenantSaveReqVO createReqVO) {
        return success(tenantService.createTenant(createReqVO));
    }

    /**
     * 更新租户
     * @param updateReqVO 租户更新请求对象
     * @return 更新成功
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:tenant:update')")
    public CommonResult<Boolean> updateTenant(@Valid @RequestBody TenantSaveReqVO updateReqVO) {
        tenantService.updateTenant(updateReqVO);
        return success(true);
    }

    /**
     * 删除租户
     * @param id 租户编号
     * @return 删除成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:tenant:delete')")
    public CommonResult<Boolean> deleteTenant(@RequestParam("id") Long id) {
        tenantService.deleteTenant(id);
        return success(true);
    }

    /**
     * 批量删除租户
     * @param ids 租户编号列表
     * @return 批量删除成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:tenant:delete')")
    public CommonResult<Boolean> deleteTenantList(@RequestParam("ids") List<Long> ids) {
        tenantService.deleteTenantList(ids);
        return success(true);
    }

    /**
     * 获取租户信息
     * @param id 租户编号
     * @return 租户信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:tenant:query')")
    public CommonResult<TenantRespVO> getTenant(@RequestParam("id") Long id) {
        TenantDO tenant = tenantService.getTenant(id);
        return success(BeanUtils.toBean(tenant, TenantRespVO.class));
    }

    /**
     * 获取租户分页信息
     * @param pageVO 分页请求对象
     * @return 租户分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:tenant:query')")
    public CommonResult<PageResult<TenantRespVO>> getTenantPage(@Valid TenantPageReqVO pageVO) {
        PageResult<TenantDO> pageResult = tenantService.getTenantPage(pageVO);
        return success(BeanUtils.toBean(pageResult, TenantRespVO.class));
    }

    /**
     * 导出租户 Excel
     * @param exportReqVO 导出请求对象
     * @param response HTTP 响应
     * @throws IOException 文件导出异常
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:tenant:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTenantExcel(@Valid TenantPageReqVO exportReqVO, HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TenantDO> list = tenantService.getTenantPage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "租户.xls", "数据", TenantRespVO.class,
                BeanUtils.toBean(list, TenantRespVO.class));
    }
}
