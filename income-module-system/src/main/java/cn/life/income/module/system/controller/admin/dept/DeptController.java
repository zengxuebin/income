package cn.life.income.module.system.controller.admin.dept;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.dept.vo.dept.DeptListReqVO;
import cn.life.income.module.system.controller.admin.dept.vo.dept.DeptRespVO;
import cn.life.income.module.system.controller.admin.dept.vo.dept.DeptSaveReqVO;
import cn.life.income.module.system.controller.admin.dept.vo.dept.DeptSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.dept.DeptDO;
import cn.life.income.module.system.service.dept.DeptService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 部门管理 Controller
 */
@RestController
@RequestMapping("/system/dept")
@Validated
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 创建部门
     * @param createReqVO 部门创建请求参数
     * @return 创建的部门ID
     */
    @PostMapping("create")
    @PreAuthorize("@ss.hasPermission('system:dept:create')")
    public CommonResult<Long> createDept(@Valid @RequestBody DeptSaveReqVO createReqVO) {
        Long deptId = deptService.createDept(createReqVO);
        return success(deptId);
    }

    /**
     * 更新部门信息
     * @param updateReqVO 部门更新请求参数
     * @return 是否更新成功
     */
    @PutMapping("update")
    @PreAuthorize("@ss.hasPermission('system:dept:update')")
    public CommonResult<Boolean> updateDept(@Valid @RequestBody DeptSaveReqVO updateReqVO) {
        deptService.updateDept(updateReqVO);
        return success(true);
    }

    /**
     * 删除部门
     * @param id 部门ID
     * @return 是否删除成功
     */
    @DeleteMapping("delete")
    @PreAuthorize("@ss.hasPermission('system:dept:delete')")
    public CommonResult<Boolean> deleteDept(@RequestParam("id") Long id) {
        deptService.deleteDept(id);
        return success(true);
    }

    /**
     * 批量删除部门
     * @param ids 部门ID列表
     * @return 是否批量删除成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:dept:delete')")
    public CommonResult<Boolean> deleteDeptList(@RequestParam("ids") List<Long> ids) {
        deptService.deleteDeptList(ids);
        return success(true);
    }

    /**
     * 获取部门列表
     * @param reqVO 部门查询参数
     * @return 部门列表
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:dept:query')")
    public CommonResult<List<DeptRespVO>> getDeptList(DeptListReqVO reqVO) {
        List<DeptDO> list = deptService.getDeptList(reqVO);
        return success(BeanUtils.toBean(list, DeptRespVO.class));
    }

    /**
     * 获取部门的精简信息列表
     * 仅包括开启的部门，主要用于前端下拉选项
     * @return 部门精简信息列表
     */
    @GetMapping(value = {"/list-all-simple", "/simple-list"})
    public CommonResult<List<DeptSimpleRespVO>> getSimpleDeptList() {
        List<DeptDO> list = deptService.getDeptList(
                new DeptListReqVO().setStatus(CommonStatusEnum.ENABLE.getStatus()));
        return success(BeanUtils.toBean(list, DeptSimpleRespVO.class));
    }

    /**
     * 获取指定部门的信息
     * @param id 部门ID
     * @return 部门信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:dept:query')")
    public CommonResult<DeptRespVO> getDept(@RequestParam("id") Long id) {
        DeptDO dept = deptService.getDept(id);
        return success(BeanUtils.toBean(dept, DeptRespVO.class));
    }

}
