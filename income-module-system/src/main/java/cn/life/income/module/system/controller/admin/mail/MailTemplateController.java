package cn.life.income.module.system.controller.admin.mail;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.mail.vo.template.*;
import cn.life.income.module.system.dal.dataobject.mail.MailTemplateDO;
import cn.life.income.module.system.service.mail.MailSendService;
import cn.life.income.module.system.service.mail.MailTemplateService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;
import static cn.life.income.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 管理后台 - 邮件模版
 */
@RestController
@RequestMapping("/system/mail-template")
public class MailTemplateController {

    @Resource
    private MailTemplateService mailTempleService;
    @Resource
    private MailSendService mailSendService;

    /**
     * 创建邮件模版
     *
     * @param createReqVO 创建请求
     * @return 创建后的邮件模版ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:mail-template:create')")
    public CommonResult<Long> createMailTemplate(@Valid @RequestBody MailTemplateSaveReqVO createReqVO){
        return success(mailTempleService.createMailTemplate(createReqVO));
    }

    /**
     * 修改邮件模版
     *
     * @param updateReqVO 更新请求
     * @return 操作结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:mail-template:update')")
    public CommonResult<Boolean> updateMailTemplate(@Valid @RequestBody MailTemplateSaveReqVO updateReqVO){
        mailTempleService.updateMailTemplate(updateReqVO);
        return success(true);
    }

    /**
     * 删除邮件模版
     *
     * @param id 邮件模版ID
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:mail-template:delete')")
    public CommonResult<Boolean> deleteMailTemplate(@RequestParam("id") Long id) {
        mailTempleService.deleteMailTemplate(id);
        return success(true);
    }

    /**
     * 批量删除邮件模版
     *
     * @param ids 邮件模版ID列表
     * @return 操作结果
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:mail-template:delete')")
    public CommonResult<Boolean> deleteMailTemplateList(@RequestParam("ids") List<Long> ids) {
        mailTempleService.deleteMailTemplateList(ids);
        return success(true);
    }

    /**
     * 获得邮件模版
     *
     * @param id 邮件模版ID
     * @return 邮件模版信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:mail-template:query')")
    public CommonResult<MailTemplateRespVO> getMailTemplate(@RequestParam("id") Long id) {
        MailTemplateDO template = mailTempleService.getMailTemplate(id);
        return success(BeanUtils.toBean(template, MailTemplateRespVO.class));
    }

    /**
     * 获得邮件模版分页
     *
     * @param pageReqVO 分页请求
     * @return 邮件模版分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-template:query')")
    public CommonResult<PageResult<MailTemplateRespVO>> getMailTemplatePage(@Valid MailTemplatePageReqVO pageReqVO) {
        PageResult<MailTemplateDO> pageResult = mailTempleService.getMailTemplatePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MailTemplateRespVO.class));
    }

    /**
     * 获得邮件模版精简列表
     *
     * @return 邮件模版精简列表
     */
    @GetMapping({"/list-all-simple", "simple-list"})
    public CommonResult<List<MailTemplateSimpleRespVO>> getSimpleTemplateList() {
        List<MailTemplateDO> list = mailTempleService.getMailTemplateList();
        return success(BeanUtils.toBean(list, MailTemplateSimpleRespVO.class));
    }

    /**
     * 发送邮件
     *
     * @param sendReqVO 发送请求
     * @return 发送结果
     */
    @PostMapping("/send-mail")
    @PreAuthorize("@ss.hasPermission('system:mail-template:send-mail')")
    public CommonResult<Long> sendMail(@Valid @RequestBody MailTemplateSendReqVO sendReqVO) {
        return success(mailSendService.sendSingleMailToAdmin(getLoginUserId(),
                sendReqVO.getToMails(), sendReqVO.getCcMails(), sendReqVO.getBccMails(),
                sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
    }
}
