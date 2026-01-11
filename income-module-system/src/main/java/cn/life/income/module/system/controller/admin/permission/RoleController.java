package cn.life.income.module.system.controller.admin.permission;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.system.controller.admin.permission.vo.role.RolePageReqVO;
import cn.life.income.module.system.controller.admin.permission.vo.role.RoleRespVO;
import cn.life.income.module.system.controller.admin.permission.vo.role.RoleSaveReqVO;
import cn.life.income.module.system.dal.dataobject.permission.RoleDO;
import cn.life.income.module.system.service.permission.RoleService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;
import static java.util.Collections.singleton;

/**
 * 管理后台 - 角色控制器
 * 提供与角色相关的 API 接口
 */
@RestController
@RequestMapping("/system/role")
@Validated
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 创建角色
     * @param createReqVO 创建角色请求
     * @return 角色 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:role:create')")
    public CommonResult<Long> createRole(@Valid @RequestBody RoleSaveReqVO createReqVO) {
        return success(roleService.createRole(createReqVO, null));
    }

    /**
     * 修改角色
     * @param updateReqVO 修改角色请求
     * @return 操作结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:role:update')")
    public CommonResult<Boolean> updateRole(@Valid @RequestBody RoleSaveReqVO updateReqVO) {
        roleService.updateRole(updateReqVO);
        return success(true);
    }

    /**
     * 删除角色
     * @param id 角色编号
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:role:delete')")
    public CommonResult<Boolean> deleteRole(@RequestParam("id") Long id) {
        roleService.deleteRole(id);
        return success(true);
    }

    /**
     * 批量删除角色
     * @param ids 角色编号列表
     * @return 操作结果
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:role:delete')")
    public CommonResult<Boolean> deleteRoleList(@RequestParam("ids") List<Long> ids) {
        roleService.deleteRoleList(ids);
        return success(true);
    }

    /**
     * 获取角色信息
     * @param id 角色编号
     * @return 角色信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:role:query')")
    public CommonResult<RoleRespVO> getRole(@RequestParam("id") Long id) {
        RoleDO role = roleService.getRole(id);
        return success(BeanUtils.toBean(role, RoleRespVO.class));
    }

    /**
     * 获取角色分页数据
     * @param pageReqVO 分页请求
     * @return 角色分页数据
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:role:query')")
    public CommonResult<PageResult<RoleRespVO>> getRolePage(RolePageReqVO pageReqVO) {
        PageResult<RoleDO> pageResult = roleService.getRolePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RoleRespVO.class));
    }

    /**
     * 获取角色精简信息列表
     * @return 精简角色信息列表
     */
    @GetMapping({"/list-all-simple", "/simple-list"})
    public CommonResult<List<RoleRespVO>> getSimpleRoleList() {
        List<RoleDO> list = roleService.getRoleListByStatus(singleton(CommonStatusEnum.ENABLE.getStatus()));
        list.sort(Comparator.comparing(RoleDO::getSort));
        return success(BeanUtils.toBean(list, RoleRespVO.class));
    }

    /**
     * 导出角色 Excel
     * @param response HTTP 响应
     * @param exportReqVO 导出请求参数
     * @throws IOException 文件写入异常
     */
    @GetMapping("/export-excel")
    @ApiAccessLog(operateType = EXPORT)
    @PreAuthorize("@ss.hasPermission('system:role:export')")
    public void export(HttpServletResponse response, @Validated RolePageReqVO exportReqVO) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<RoleDO> list = roleService.getRolePage(exportReqVO).getList();
        // 输出 Excel 文件
        ExcelUtils.write(response, "角色数据.xls", "数据", RoleRespVO.class,
                BeanUtils.toBean(list, RoleRespVO.class));
    }
}
