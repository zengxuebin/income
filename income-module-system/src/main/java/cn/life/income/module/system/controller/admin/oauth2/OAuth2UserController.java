package cn.life.income.module.system.controller.admin.oauth2;

import cn.hutool.core.collection.CollUtil;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.oauth2.vo.user.OAuth2UserInfoRespVO;
import cn.life.income.module.system.controller.admin.oauth2.vo.user.OAuth2UserUpdateReqVO;
import cn.life.income.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import cn.life.income.module.system.dal.dataobject.dept.DeptDO;
import cn.life.income.module.system.dal.dataobject.dept.PostDO;
import cn.life.income.module.system.dal.dataobject.user.AdminUserDO;
import cn.life.income.module.system.service.dept.DeptService;
import cn.life.income.module.system.service.dept.PostService;
import cn.life.income.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 管理后台 - OAuth2.0 用户管理
 *
 * 1. getUserInfo 方法需要满足 scope = user.read 权限，才能获取用户信息。
 * 2. updateUserInfo 方法需要满足 scope = user.write 权限，才能更新用户信息。
 *
 * 提供获取和更新用户基本信息的 API。
 *
 * @author zengxuebin
 */
@RestController
@RequestMapping("/system/oauth2/user")
@Validated
@Slf4j
public class OAuth2UserController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;

    /**
     * 获取用户基本信息
     *
     * 需要满足 scope = user.read 权限，才能调用此接口。
     * @return 用户基本信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasScope('user.read')")
    public CommonResult<OAuth2UserInfoRespVO> getUserInfo() {
        // 获得用户基本信息
        AdminUserDO user = userService.getUser(getLoginUserId());
        OAuth2UserInfoRespVO resp = BeanUtils.toBean(user, OAuth2UserInfoRespVO.class);

        // 获得部门信息
        if (user.getDeptId() != null) {
            DeptDO dept = deptService.getDept(user.getDeptId());
            resp.setDept(BeanUtils.toBean(dept, OAuth2UserInfoRespVO.Dept.class));
        }

        // 获得岗位信息
        if (CollUtil.isNotEmpty(user.getPostIds())) {
            List<PostDO> posts = postService.getPostList(user.getPostIds());
            resp.setPosts(BeanUtils.toBean(posts, OAuth2UserInfoRespVO.Post.class));
        }

        return success(resp);
    }

    /**
     * 更新用户基本信息
     *
     * 需要满足 scope = user.write 权限，才能调用此接口。
     * @param reqVO 更新的用户信息
     * @return 更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasScope('user.write')")
    public CommonResult<Boolean> updateUserInfo(@Valid @RequestBody OAuth2UserUpdateReqVO reqVO) {
        // 将请求数据转换为 UserProfileUpdateReqVO 对象，复用接口
        userService.updateUserProfile(getLoginUserId(), BeanUtils.toBean(reqVO, UserProfileUpdateReqVO.class));
        return success(true);
    }
}
