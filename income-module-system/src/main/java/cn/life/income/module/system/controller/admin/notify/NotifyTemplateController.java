package cn.life.income.module.system.controller.admin.notify;

import cn.life.income.framework.common.enums.UserTypeEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.notify.vo.template.NotifyTemplatePageReqVO;
import cn.life.income.module.system.controller.admin.notify.vo.template.NotifyTemplateRespVO;
import cn.life.income.module.system.controller.admin.notify.vo.template.NotifyTemplateSaveReqVO;
import cn.life.income.module.system.controller.admin.notify.vo.template.NotifyTemplateSendReqVO;
import cn.life.income.module.system.dal.dataobject.notify.NotifyTemplateDO;
import cn.life.income.module.system.service.notify.NotifySendService;
import cn.life.income.module.system.service.notify.NotifyTemplateService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 站内信模板管理
 * 提供对站内信模板的创建、更新、删除、分页查询和发送等操作。
 */
@RestController
@RequestMapping("/system/notify-template")
@Validated
public class NotifyTemplateController {

    @Resource
    private NotifyTemplateService notifyTemplateService;

    @Resource
    private NotifySendService notifySendService;

    /**
     * 创建站内信模板
     *
     * @param createReqVO 创建请求对象
     * @return 创建的模板 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:notify-template:create')")
    public CommonResult<Long> createNotifyTemplate(@Valid @RequestBody NotifyTemplateSaveReqVO createReqVO) {
        return success(notifyTemplateService.createNotifyTemplate(createReqVO));
    }

    /**
     * 更新站内信模板
     *
     * @param updateReqVO 更新请求对象
     * @return 是否更新成功
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:notify-template:update')")
    public CommonResult<Boolean> updateNotifyTemplate(@Valid @RequestBody NotifyTemplateSaveReqVO updateReqVO) {
        notifyTemplateService.updateNotifyTemplate(updateReqVO);
        return success(true);
    }

    /**
     * 删除站内信模板
     *
     * @param id 模板编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:notify-template:delete')")
    public CommonResult<Boolean> deleteNotifyTemplate(@RequestParam("id") Long id) {
        notifyTemplateService.deleteNotifyTemplate(id);
        return success(true);
    }

    /**
     * 批量删除站内信模板
     *
     * @param ids 模板编号列表
     * @return 是否删除成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:notify-template:delete')")
    public CommonResult<Boolean> deleteNotifyTemplateList(@RequestParam("ids") List<Long> ids) {
        notifyTemplateService.deleteNotifyTemplateList(ids);
        return success(true);
    }

    /**
     * 获取指定站内信模板
     *
     * @param id 模板编号
     * @return 模板响应对象
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:notify-template:query')")
    public CommonResult<NotifyTemplateRespVO> getNotifyTemplate(@RequestParam("id") Long id) {
        NotifyTemplateDO template = notifyTemplateService.getNotifyTemplate(id);
        return success(BeanUtils.toBean(template, NotifyTemplateRespVO.class));
    }

    /**
     * 获取站内信模板分页列表
     *
     * @param pageVO 分页请求对象
     * @return 分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:notify-template:query')")
    public CommonResult<PageResult<NotifyTemplateRespVO>> getNotifyTemplatePage(@Valid NotifyTemplatePageReqVO pageVO) {
        PageResult<NotifyTemplateDO> pageResult = notifyTemplateService.getNotifyTemplatePage(pageVO);
        return success(BeanUtils.toBean(pageResult, NotifyTemplateRespVO.class));
    }

    /**
     * 发送站内信
     * 根据不同的用户类型，调用对应的发送服务
     *
     * @param sendReqVO 发送请求对象
     * @return 发送操作的结果
     */
    @PostMapping("/send-notify")
    @PreAuthorize("@ss.hasPermission('system:notify-template:send-notify')")
    public CommonResult<Long> sendNotify(@Valid @RequestBody NotifyTemplateSendReqVO sendReqVO) {
        if (UserTypeEnum.MEMBER.getValue().equals(sendReqVO.getUserType())) {
            return success(notifySendService.sendSingleNotifyToMember(sendReqVO.getUserId(),
                    sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
        } else {
            return success(notifySendService.sendSingleNotifyToAdmin(sendReqVO.getUserId(),
                    sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
        }
    }
}
