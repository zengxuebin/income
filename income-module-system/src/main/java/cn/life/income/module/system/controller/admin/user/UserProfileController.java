package cn.life.income.module.system.controller.admin.user;

import cn.hutool.core.collection.CollUtil;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.datapermission.core.annotation.DataPermission;
import cn.life.income.module.system.controller.admin.user.vo.profile.UserProfileRespVO;
import cn.life.income.module.system.controller.admin.user.vo.profile.UserProfileUpdatePasswordReqVO;
import cn.life.income.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import cn.life.income.module.system.convert.user.UserConvert;
import cn.life.income.module.system.dal.dataobject.dept.DeptDO;
import cn.life.income.module.system.dal.dataobject.dept.PostDO;
import cn.life.income.module.system.dal.dataobject.permission.RoleDO;
import cn.life.income.module.system.dal.dataobject.user.AdminUserDO;
import cn.life.income.module.system.service.dept.DeptService;
import cn.life.income.module.system.service.dept.PostService;
import cn.life.income.module.system.service.permission.PermissionService;
import cn.life.income.module.system.service.permission.RoleService;
import cn.life.income.module.system.service.user.AdminUserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 管理后台 - 用户个人中心
 */
@RestController
@RequestMapping("/system/user/profile")
@Validated
@Slf4j
public class UserProfileController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;

    /**
     * 获取登录用户信息
     * 关闭数据权限，避免只查看自己时，查询不到部门。
     *
     * @return 登录用户信息
     */
    @GetMapping("/get")
    @DataPermission(enable = false)
    public CommonResult<UserProfileRespVO> getUserProfile() {
        // 获得用户基本信息
        AdminUserDO user = userService.getUser(getLoginUserId());
        // 获得用户角色
        List<RoleDO> userRoles = roleService.getRoleListFromCache(permissionService.getUserRoleIdListByUserId(user.getId()));
        // 获得部门信息
        DeptDO dept = user.getDeptId() != null ? deptService.getDept(user.getDeptId()) : null;
        // 获得岗位信息
        List<PostDO> posts = CollUtil.isNotEmpty(user.getPostIds()) ? postService.getPostList(user.getPostIds()) : null;
        return success(UserConvert.INSTANCE.convert(user, userRoles, dept, posts));
    }

    /**
     * 修改用户个人信息
     *
     * @param reqVO 用户个人信息更新请求体
     * @return 操作结果
     */
    @PutMapping("/update")
    public CommonResult<Boolean> updateUserProfile(@Valid @RequestBody UserProfileUpdateReqVO reqVO) {
        userService.updateUserProfile(getLoginUserId(), reqVO);
        return success(true);
    }

    /**
     * 修改用户个人密码
     *
     * @param reqVO 用户密码更新请求体
     * @return 操作结果
     */
    @PutMapping("/update-password")
    public CommonResult<Boolean> updateUserProfilePassword(@Valid @RequestBody UserProfileUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(getLoginUserId(), reqVO);
        return success(true);
    }

}
