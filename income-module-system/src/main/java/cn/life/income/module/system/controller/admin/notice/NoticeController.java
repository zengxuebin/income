package cn.life.income.module.system.controller.admin.notice;

import cn.hutool.core.lang.Assert;
import cn.life.income.framework.common.enums.UserTypeEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.infra.api.websocket.WebSocketSenderApi;
import cn.life.income.module.system.controller.admin.notice.vo.NoticePageReqVO;
import cn.life.income.module.system.controller.admin.notice.vo.NoticeRespVO;
import cn.life.income.module.system.controller.admin.notice.vo.NoticeSaveReqVO;
import cn.life.income.module.system.dal.dataobject.notice.NoticeDO;
import cn.life.income.module.system.service.notice.NoticeService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 通知公告控制器
 */
@RestController
@RequestMapping("/system/notice")
@Validated
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @Resource
    private WebSocketSenderApi webSocketSenderApi;

    /**
     * 创建通知公告
     *
     * @param createReqVO 创建请求的 VO
     * @return 返回通知公告的 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:notice:create')")
    public CommonResult<Long> createNotice(@Valid @RequestBody NoticeSaveReqVO createReqVO) {
        Long noticeId = noticeService.createNotice(createReqVO);
        return success(noticeId);
    }

    /**
     * 修改通知公告
     *
     * @param updateReqVO 更新请求的 VO
     * @return 返回操作成功标志
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:notice:update')")
    public CommonResult<Boolean> updateNotice(@Valid @RequestBody NoticeSaveReqVO updateReqVO) {
        noticeService.updateNotice(updateReqVO);
        return success(true);
    }

    /**
     * 删除通知公告
     *
     * @param id 通知公告的 ID
     * @return 返回操作成功标志
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteNotice(@RequestParam("id") Long id) {
        noticeService.deleteNotice(id);
        return success(true);
    }

    /**
     * 批量删除通知公告
     *
     * @param ids 通知公告的 ID 列表
     * @return 返回操作成功标志
     */
    @DeleteMapping("/delete-list")
    public CommonResult<Boolean> deleteNoticeList(@RequestParam("ids") List<Long> ids) {
        noticeService.deleteNoticeList(ids);
        return success(true);
    }

    /**
     * 获取通知公告分页列表
     *
     * @param pageReqVO 分页请求 VO
     * @return 返回通知公告的分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:notice:query')")
    public CommonResult<PageResult<NoticeRespVO>> getNoticePage(@Validated NoticePageReqVO pageReqVO) {
        PageResult<NoticeDO> pageResult = noticeService.getNoticePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, NoticeRespVO.class));
    }

    /**
     * 获取单个通知公告
     *
     * @param id 通知公告的 ID
     * @return 返回通知公告的详细信息
     */
    @GetMapping("/get")
    public CommonResult<NoticeRespVO> getNotice(@RequestParam("id") Long id) {
        NoticeDO notice = noticeService.getNotice(id);
        return success(BeanUtils.toBean(notice, NoticeRespVO.class));
    }

    /**
     * 推送通知公告到 WebSocket 在线用户
     *
     * @param id 通知公告的 ID
     * @return 返回推送是否成功的标志
     */
    @PostMapping("/push")
    @PreAuthorize("@ss.hasPermission('system:notice:update')")
    public CommonResult<Boolean> push(@RequestParam("id") Long id) {
        NoticeDO notice = noticeService.getNotice(id);
        Assert.notNull(notice, "公告不能为空");
        // 通过 websocket 推送给在线的用户
        webSocketSenderApi.sendObject(UserTypeEnum.ADMIN.getValue(), "notice-push", notice);
        return success(true);
    }
}
