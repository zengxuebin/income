package cn.life.income.module.infra.controller.admin.config;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.infra.controller.admin.config.vo.ConfigPageReqVO;
import cn.life.income.module.infra.controller.admin.config.vo.ConfigRespVO;
import cn.life.income.module.infra.controller.admin.config.vo.ConfigSaveReqVO;
import cn.life.income.module.infra.convert.config.ConfigConvert;
import cn.life.income.module.infra.dal.dataobject.config.ConfigDO;
import cn.life.income.module.infra.enums.ErrorCodeConstants;
import cn.life.income.module.infra.service.config.ConfigService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 参数配置
 */
@RestController
@RequestMapping("/infra/config")
@Validated
public class ConfigController {

    @Resource
    private ConfigService configService;

    /**
     * 创建参数配置
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:config:create')")
    public CommonResult<Long> createConfig(@Valid @RequestBody ConfigSaveReqVO createReqVO) {
        return success(configService.createConfig(createReqVO));
    }

    /**
     * 修改参数配置
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:config:update')")
    public CommonResult<Boolean> updateConfig(@Valid @RequestBody ConfigSaveReqVO updateReqVO) {
        configService.updateConfig(updateReqVO);
        return success(true);
    }

    /**
     * 删除参数配置
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:config:delete')")
    public CommonResult<Boolean> deleteConfig(@RequestParam("id") Long id) {
        configService.deleteConfig(id);
        return success(true);
    }

    /**
     * 批量删除参数配置
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('infra:config:delete')")
    public CommonResult<Boolean> deleteConfigList(@RequestParam("ids") List<Long> ids) {
        configService.deleteConfigList(ids);
        return success(true);
    }

    /**
     * 获取参数配置
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<ConfigRespVO> getConfig(@RequestParam("id") Long id) {
        return success(ConfigConvert.INSTANCE.convert(configService.getConfig(id)));
    }

    /**
     * 根据参数键名查询参数值
     */
    @GetMapping("/get-value-by-key")
    public CommonResult<String> getConfigKey(@RequestParam("key") String key) {
        ConfigDO config = configService.getConfigByKey(key);
        if (config == null) {
            return success(null);
        }
        if (!config.getVisible()) {
            throw exception(ErrorCodeConstants.CONFIG_GET_VALUE_ERROR_IF_VISIBLE);
        }
        return success(config.getValue());
    }

    /**
     * 获取参数配置分页
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<PageResult<ConfigRespVO>> getConfigPage(@Valid ConfigPageReqVO pageReqVO) {
        PageResult<ConfigDO> page = configService.getConfigPage(pageReqVO);
        return success(ConfigConvert.INSTANCE.convertPage(page));
    }

    /**
     * 导出参数配置
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:config:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportConfig(ConfigPageReqVO exportReqVO, HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ConfigDO> list = configService.getConfigPage(exportReqVO).getList();
        ExcelUtils.write(response, "参数配置.xls", "数据", ConfigRespVO.class,
                ConfigConvert.INSTANCE.convertList(list));
    }
}
