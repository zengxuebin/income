package cn.life.income.module.system.controller.admin.dept;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.system.controller.admin.dept.vo.post.PostPageReqVO;
import cn.life.income.module.system.controller.admin.dept.vo.post.PostRespVO;
import cn.life.income.module.system.controller.admin.dept.vo.post.PostSaveReqVO;
import cn.life.income.module.system.controller.admin.dept.vo.post.PostSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.dept.PostDO;
import cn.life.income.module.system.service.dept.PostService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 岗位管理 Controller
 */
@RestController
@RequestMapping("/system/post")
@Validated
public class PostController {

    @Resource
    private PostService postService;

    /**
     * 创建岗位
     *
     * @param createReqVO 创建岗位的请求对象
     * @return 返回岗位ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<Long> createPost(@Valid @RequestBody PostSaveReqVO createReqVO) {
        Long postId = postService.createPost(createReqVO);
        return success(postId);
    }

    /**
     * 更新岗位
     *
     * @param updateReqVO 更新岗位的请求对象
     * @return 返回更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:post:update')")
    public CommonResult<Boolean> updatePost(@Valid @RequestBody PostSaveReqVO updateReqVO) {
        postService.updatePost(updateReqVO);
        return success(true);
    }

    /**
     * 删除岗位
     *
     * @param id 岗位ID
     * @return 返回删除结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:post:delete')")
    public CommonResult<Boolean> deletePost(@RequestParam("id") Long id) {
        postService.deletePost(id);
        return success(true);
    }

    /**
     * 批量删除岗位
     *
     * @param ids 岗位ID列表
     * @return 返回批量删除结果
     */
    @DeleteMapping("delete-list")
    @PreAuthorize("@ss.hasPermission('system:post:delete')")
    public CommonResult<Boolean> deletePostList(@RequestParam("ids") List<Long> ids) {
        postService.deletePostList(ids);
        return success(true);
    }

    /**
     * 获取岗位信息
     *
     * @param id 岗位ID
     * @return 返回岗位详细信息
     */
    @GetMapping(value = "/get")
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<PostRespVO> getPost(@RequestParam("id") Long id) {
        PostDO post = postService.getPost(id);
        return success(BeanUtils.toBean(post, PostRespVO.class));
    }

    /**
     * 获取所有岗位的精简信息列表
     *
     * @return 返回岗位精简信息列表
     */
    @GetMapping(value = {"/list-all-simple", "simple-list"})
    public CommonResult<List<PostSimpleRespVO>> getSimplePostList() {
        // 获得岗位列表，只要开启状态的
        List<PostDO> list = postService.getPostList(null, Collections.singleton(CommonStatusEnum.ENABLE.getStatus()));
        // 排序后，返回给前端
        list.sort(Comparator.comparing(PostDO::getSort));
        return success(BeanUtils.toBean(list, PostSimpleRespVO.class));
    }

    /**
     * 获取岗位的分页列表
     *
     * @param pageReqVO 分页请求对象
     * @return 返回分页后的岗位列表
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<PageResult<PostRespVO>> getPostPage(@Validated PostPageReqVO pageReqVO) {
        PageResult<PostDO> pageResult = postService.getPostPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, PostRespVO.class));
    }

    /**
     * 导出岗位数据为 Excel 文件
     *
     * @param response 响应对象
     * @param reqVO 请求参数对象
     * @throws IOException 文件写入异常
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:post:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void export(HttpServletResponse response, @Validated PostPageReqVO reqVO) throws IOException {
        reqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<PostDO> list = postService.getPostPage(reqVO).getList();
        // 输出
        ExcelUtils.write(response, "岗位数据.xls", "岗位列表", PostRespVO.class,
                BeanUtils.toBean(list, PostRespVO.class));
    }
}
