package cn.life.income.module.system.controller.admin.tenant;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.tenant.vo.packages.TenantPackagePageReqVO;
import cn.life.income.module.system.controller.admin.tenant.vo.packages.TenantPackageRespVO;
import cn.life.income.module.system.controller.admin.tenant.vo.packages.TenantPackageSaveReqVO;
import cn.life.income.module.system.controller.admin.tenant.vo.packages.TenantPackageSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.tenant.TenantPackageDO;
import cn.life.income.module.system.service.tenant.TenantPackageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 租户套餐控制器
 */
@RestController
@RequestMapping("/system/tenant-package")
@Validated
public class TenantPackageController {

    @Resource
    private TenantPackageService tenantPackageService;

    /**
     * 创建租户套餐
     * @param createReqVO 租户套餐创建请求对象
     * @return 创建成功后的租户套餐编号
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:create')")
    public CommonResult<Long> createTenantPackage(@Valid @RequestBody TenantPackageSaveReqVO createReqVO) {
        return success(tenantPackageService.createTenantPackage(createReqVO));
    }

    /**
     * 更新租户套餐
     * @param updateReqVO 租户套餐更新请求对象
     * @return 更新成功
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:update')")
    public CommonResult<Boolean> updateTenantPackage(@Valid @RequestBody TenantPackageSaveReqVO updateReqVO) {
        tenantPackageService.updateTenantPackage(updateReqVO);
        return success(true);
    }

    /**
     * 删除租户套餐
     * @param id 租户套餐编号
     * @return 删除成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:delete')")
    public CommonResult<Boolean> deleteTenantPackage(@RequestParam("id") Long id) {
        tenantPackageService.deleteTenantPackage(id);
        return success(true);
    }

    /**
     * 批量删除租户套餐
     * @param ids 租户套餐编号列表
     * @return 批量删除成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:delete')")
    public CommonResult<Boolean> deleteTenantPackageList(@RequestParam("ids") List<Long> ids) {
        tenantPackageService.deleteTenantPackageList(ids);
        return success(true);
    }

    /**
     * 获取租户套餐信息
     * @param id 租户套餐编号
     * @return 租户套餐信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<TenantPackageRespVO> getTenantPackage(@RequestParam("id") Long id) {
        TenantPackageDO tenantPackage = tenantPackageService.getTenantPackage(id);
        return success(BeanUtils.toBean(tenantPackage, TenantPackageRespVO.class));
    }

    /**
     * 获取租户套餐分页信息
     * @param pageVO 分页请求对象
     * @return 租户套餐分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<PageResult<TenantPackageRespVO>> getTenantPackagePage(@Valid TenantPackagePageReqVO pageVO) {
        PageResult<TenantPackageDO> pageResult = tenantPackageService.getTenantPackagePage(pageVO);
        return success(BeanUtils.toBean(pageResult, TenantPackageRespVO.class));
    }

    /**
     * 获取租户套餐精简信息列表
     * 只包含被开启的租户套餐，主要用于前端的下拉选项
     * @return 租户套餐精简信息列表
     */
    @GetMapping({"/get-simple-list", "simple-list"})
    public CommonResult<List<TenantPackageSimpleRespVO>> getTenantPackageList() {
        List<TenantPackageDO> list = tenantPackageService.getTenantPackageListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(BeanUtils.toBean(list, TenantPackageSimpleRespVO.class));
    }
}
