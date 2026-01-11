package cn.life.income.module.infra.controller.admin.file;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.infra.controller.admin.file.vo.config.FileConfigPageReqVO;
import cn.life.income.module.infra.controller.admin.file.vo.config.FileConfigRespVO;
import cn.life.income.module.infra.controller.admin.file.vo.config.FileConfigSaveReqVO;
import cn.life.income.module.infra.dal.dataobject.file.FileConfigDO;
import cn.life.income.module.infra.service.file.FileConfigService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 文件配置
 */
@RestController
@RequestMapping("/infra/file-config")
@Validated
public class FileConfigController {

    @Resource
    private FileConfigService fileConfigService;

    /**
     * 创建文件配置
     * @param createReqVO 文件配置创建请求VO
     * @return 创建结果
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:file-config:create')")
    public CommonResult<Long> createFileConfig(@Valid @RequestBody FileConfigSaveReqVO createReqVO) {
        return success(fileConfigService.createFileConfig(createReqVO));
    }

    /**
     * 更新文件配置
     * @param updateReqVO 文件配置更新请求VO
     * @return 更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:file-config:update')")
    public CommonResult<Boolean> updateFileConfig(@Valid @RequestBody FileConfigSaveReqVO updateReqVO) {
        fileConfigService.updateFileConfig(updateReqVO);
        return success(true);
    }

    /**
     * 更新文件配置为 Master
     * @param id 文件配置编号
     * @return 更新结果
     */
    @PutMapping("/update-master")
    @PreAuthorize("@ss.hasPermission('infra:file-config:update')")
    public CommonResult<Boolean> updateFileConfigMaster(@RequestParam("id") Long id) {
        fileConfigService.updateFileConfigMaster(id);
        return success(true);
    }

    /**
     * 删除文件配置
     * @param id 文件配置编号
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:file-config:delete')")
    public CommonResult<Boolean> deleteFileConfig(@RequestParam("id") Long id) {
        fileConfigService.deleteFileConfig(id);
        return success(true);
    }

    /**
     * 批量删除文件配置
     * @param ids 文件配置编号列表
     * @return 删除结果
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('infra:file-config:delete')")
    public CommonResult<Boolean> deleteFileConfigList(@RequestParam("ids") List<Long> ids) {
        fileConfigService.deleteFileConfigList(ids);
        return success(true);
    }

    /**
     * 获取文件配置
     * @param id 文件配置编号
     * @return 文件配置响应VO
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<FileConfigRespVO> getFileConfig(@RequestParam("id") Long id) {
        FileConfigDO config = fileConfigService.getFileConfig(id);
        return success(BeanUtils.toBean(config, FileConfigRespVO.class));
    }

    /**
     * 获取文件配置分页
     * @param pageVO 文件配置分页请求VO
     * @return 文件配置分页响应
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<PageResult<FileConfigRespVO>> getFileConfigPage(@Valid FileConfigPageReqVO pageVO) {
        PageResult<FileConfigDO> pageResult = fileConfigService.getFileConfigPage(pageVO);
        return success(BeanUtils.toBean(pageResult, FileConfigRespVO.class));
    }

    /**
     * 测试文件配置是否正确
     * @param id 文件配置编号
     * @return 配置测试结果URL
     */
    @GetMapping("/test")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<String> testFileConfig(@RequestParam("id") Long id) throws Exception {
        String url = fileConfigService.testFileConfig(id);
        return success(url);
    }
}
