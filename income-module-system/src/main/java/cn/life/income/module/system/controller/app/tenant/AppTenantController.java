package cn.life.income.module.system.controller.app.tenant;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.tenant.core.aop.TenantIgnore;
import cn.life.income.module.system.controller.app.tenant.vo.AppTenantRespVO;
import cn.life.income.module.system.dal.dataobject.tenant.TenantDO;
import cn.life.income.module.system.service.tenant.TenantService;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 租户
 */
@RestController
@RequestMapping("/system/tenant")
public class AppTenantController {

    @Resource
    private TenantService tenantService;

    /**
     * 使用域名，获得租户信息
     *
     * @param website 域名
     * @return 租户信息
     */
    @GetMapping("/get-by-website")
    @PermitAll
    @TenantIgnore
    public CommonResult<AppTenantRespVO> getTenantByWebsite(@RequestParam("website") String website) {
        TenantDO tenant = tenantService.getTenantByWebsite(website);
        if (tenant == null || CommonStatusEnum.isDisable(tenant.getStatus())) {
            return success(null);
        }
        return success(BeanUtils.toBean(tenant, AppTenantRespVO.class));
    }

}
