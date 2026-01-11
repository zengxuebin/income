package cn.life.income.module.infra.controller.admin.db;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import cn.life.income.module.infra.controller.admin.db.vo.DataSourceConfigSaveReqVO;
import cn.life.income.module.infra.dal.dataobject.db.DataSourceConfigDO;
import cn.life.income.module.infra.service.db.DataSourceConfigService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 数据源配置
 */
@RestController
@RequestMapping("/infra/data-source-config")
@Validated
public class DataSourceConfigController {

    @Resource
    private DataSourceConfigService dataSourceConfigService;

    /**
     * 创建数据源配置
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:create')")
    public CommonResult<Long> createDataSourceConfig(@Valid @RequestBody DataSourceConfigSaveReqVO createReqVO) {
        return success(dataSourceConfigService.createDataSourceConfig(createReqVO));
    }

    /**
     * 更新数据源配置
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:update')")
    public CommonResult<Boolean> updateDataSourceConfig(@Valid @RequestBody DataSourceConfigSaveReqVO updateReqVO) {
        dataSourceConfigService.updateDataSourceConfig(updateReqVO);
        return success(true);
    }

    /**
     * 删除数据源配置
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteDataSourceConfig(@RequestParam("id") Long id) {
        dataSourceConfigService.deleteDataSourceConfig(id);
        return success(true);
    }

    /**
     * 批量删除数据源配置
     */
    @DeleteMapping("/delete-list")
    public CommonResult<Boolean> deleteDataSourceConfigList(@RequestParam("ids") List<Long> ids) {
        dataSourceConfigService.deleteDataSourceConfigList(ids);
        return success(true);
    }

    /**
     * 获得数据源配置
     */
    @GetMapping("/get")
    public CommonResult<DataSourceConfigRespVO> getDataSourceConfig(@RequestParam("id") Long id) {
        DataSourceConfigDO config = dataSourceConfigService.getDataSourceConfig(id);
        return success(BeanUtils.toBean(config, DataSourceConfigRespVO.class));
    }

    /**
     * 获得数据源配置列表
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:query')")
    public CommonResult<List<DataSourceConfigRespVO>> getDataSourceConfigList() {
        List<DataSourceConfigDO> list = dataSourceConfigService.getDataSourceConfigList();
        return success(BeanUtils.toBean(list, DataSourceConfigRespVO.class));
    }
}
