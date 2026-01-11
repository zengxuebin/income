package cn.life.income.module.system.controller.admin.notify;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.enums.UserTypeEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.notify.vo.message.NotifyMessageMyPageReqVO;
import cn.life.income.module.system.controller.admin.notify.vo.message.NotifyMessagePageReqVO;
import cn.life.income.module.system.controller.admin.notify.vo.message.NotifyMessageRespVO;
import cn.life.income.module.system.dal.dataobject.notify.NotifyMessageDO;
import cn.life.income.module.system.service.notify.NotifyMessageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 管理后台 - 我的站内信
 */
@RestController
@RequestMapping("/system/notify-message")
@Validated
public class NotifyMessageController {

    @Resource
    private NotifyMessageService notifyMessageService;

    // ========== 管理所有的站内信 ==========

    /**
     * 获得站内信
     *
     * @param id 通知公告的编号
     * @return 返回站内信的详细信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:notify-message:query')")
    public CommonResult<NotifyMessageRespVO> getNotifyMessage(@RequestParam("id") Long id) {
        NotifyMessageDO message = notifyMessageService.getNotifyMessage(id);
        return success(BeanUtils.toBean(message, NotifyMessageRespVO.class));
    }

    /**
     * 获得站内信分页
     *
     * @param pageVO 分页请求 VO
     * @return 返回站内信的分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:notify-message:query')")
    public CommonResult<PageResult<NotifyMessageRespVO>> getNotifyMessagePage(@Valid NotifyMessagePageReqVO pageVO) {
        PageResult<NotifyMessageDO> pageResult = notifyMessageService.getNotifyMessagePage(pageVO);
        return success(BeanUtils.toBean(pageResult, NotifyMessageRespVO.class));
    }

    // ========== 查看自己的站内信 ==========

    /**
     * 获得我的站内信分页
     *
     * @param pageVO 分页请求 VO
     * @return 返回我的站内信分页结果
     */
    @GetMapping("/my-page")
    public CommonResult<PageResult<NotifyMessageRespVO>> getMyNotifyMessagePage(@Valid NotifyMessageMyPageReqVO pageVO) {
        PageResult<NotifyMessageDO> pageResult = notifyMessageService.getMyMyNotifyMessagePage(
                pageVO, getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(BeanUtils.toBean(pageResult, NotifyMessageRespVO.class));
    }

    /**
     * 标记站内信为已读
     *
     * @param ids 需要标记为已读的站内信 ID 列表
     * @return 返回操作结果
     */
    @PutMapping("/update-read")
    public CommonResult<Boolean> updateNotifyMessageRead(@RequestParam("ids") List<Long> ids) {
        notifyMessageService.updateNotifyMessageRead(ids, getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(Boolean.TRUE);
    }

    /**
     * 标记所有站内信为已读
     *
     * @return 返回操作结果
     */
    @PutMapping("/update-all-read")
    public CommonResult<Boolean> updateAllNotifyMessageRead() {
        notifyMessageService.updateAllNotifyMessageRead(getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(Boolean.TRUE);
    }

    /**
     * 获取当前用户的最新站内信列表，默认返回 10 条
     *
     * @param size 返回的站内信数量，默认 10
     * @return 返回站内信列表
     */
    @GetMapping("/get-unread-list")
    public CommonResult<List<NotifyMessageRespVO>> getUnreadNotifyMessageList(
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        List<NotifyMessageDO> list = notifyMessageService.getUnreadNotifyMessageList(
                getLoginUserId(), UserTypeEnum.ADMIN.getValue(), size);
        return success(BeanUtils.toBean(list, NotifyMessageRespVO.class));
    }

    /**
     * 获得当前用户的未读站内信数量
     *
     * @return 返回未读站内信数量
     */
    @GetMapping("/get-unread-count")
    @ApiAccessLog(enable = false) // 由于前端会不断轮询该接口，记录日志没有意义
    public CommonResult<Long> getUnreadNotifyMessageCount() {
        return success(notifyMessageService.getUnreadNotifyMessageCount(
                getLoginUserId(), UserTypeEnum.ADMIN.getValue()));
    }

}
