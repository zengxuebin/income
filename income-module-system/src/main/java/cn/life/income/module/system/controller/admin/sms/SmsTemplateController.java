package cn.life.income.module.system.controller.admin.sms;

import cn.life.income.framework.apilog.core.annotation.ApiAccessLog;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.framework.excel.core.util.ExcelUtils;
import cn.life.income.module.system.controller.admin.sms.vo.template.SmsTemplatePageReqVO;
import cn.life.income.module.system.controller.admin.sms.vo.template.SmsTemplateRespVO;
import cn.life.income.module.system.controller.admin.sms.vo.template.SmsTemplateSaveReqVO;
import cn.life.income.module.system.controller.admin.sms.vo.template.SmsTemplateSendReqVO;
import cn.life.income.module.system.dal.dataobject.sms.SmsTemplateDO;
import cn.life.income.module.system.service.sms.SmsSendService;
import cn.life.income.module.system.service.sms.SmsTemplateService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.life.income.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 短信模板管理
 */
@RestController
@RequestMapping("/system/sms-template")
public class SmsTemplateController {

    @Resource
    private SmsTemplateService smsTemplateService;
    @Resource
    private SmsSendService smsSendService;

    /**
     * 创建短信模板
     * @param createReqVO 创建请求参数
     * @return 创建成功的模板 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:sms-template:create')")
    public CommonResult<Long> createSmsTemplate(@Valid @RequestBody SmsTemplateSaveReqVO createReqVO) {
        return success(smsTemplateService.createSmsTemplate(createReqVO));
    }

    /**
     * 更新短信模板
     * @param updateReqVO 更新请求参数
     * @return 更新是否成功
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:sms-template:update')")
    public CommonResult<Boolean> updateSmsTemplate(@Valid @RequestBody SmsTemplateSaveReqVO updateReqVO) {
        smsTemplateService.updateSmsTemplate(updateReqVO);
        return success(true);
    }

    /**
     * 删除短信模板
     * @param id 短信模板 ID
     * @return 删除是否成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:sms-template:delete')")
    public CommonResult<Boolean> deleteSmsTemplate(@RequestParam("id") Long id) {
        smsTemplateService.deleteSmsTemplate(id);
        return success(true);
    }

    /**
     * 批量删除短信模板
     * @param ids 短信模板 ID 列表
     * @return 批量删除是否成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:sms-template:delete')")
    public CommonResult<Boolean> deleteSmsTemplateList(@RequestParam("ids") List<Long> ids) {
        smsTemplateService.deleteSmsTemplateList(ids);
        return success(true);
    }

    /**
     * 根据 ID 获取短信模板
     * @param id 短信模板 ID
     * @return 短信模板详细信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:sms-template:query')")
    public CommonResult<SmsTemplateRespVO> getSmsTemplate(@RequestParam("id") Long id) {
        SmsTemplateDO template = smsTemplateService.getSmsTemplate(id);
        return success(BeanUtils.toBean(template, SmsTemplateRespVO.class));
    }

    /**
     * 获取短信模板分页
     * @param pageVO 分页请求参数
     * @return 短信模板分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:sms-template:query')")
    public CommonResult<PageResult<SmsTemplateRespVO>> getSmsTemplatePage(@Valid SmsTemplatePageReqVO pageVO) {
        PageResult<SmsTemplateDO> pageResult = smsTemplateService.getSmsTemplatePage(pageVO);
        return success(BeanUtils.toBean(pageResult, SmsTemplateRespVO.class));
    }

    /**
     * 导出短信模板 Excel
     * @param exportReqVO 导出请求参数
     * @param response HTTP 响应
     * @throws IOException 导出失败时抛出
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:sms-template:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSmsTemplateExcel(@Valid SmsTemplatePageReqVO exportReqVO,
                                       HttpServletResponse response) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SmsTemplateDO> list = smsTemplateService.getSmsTemplatePage(exportReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "短信模板.xls", "数据", SmsTemplateRespVO.class,
                BeanUtils.toBean(list, SmsTemplateRespVO.class));
    }

    /**
     * 发送短信
     * @param sendReqVO 发送请求参数
     * @return 发送短信的任务 ID
     */
    @PostMapping("/send-sms")
    @PreAuthorize("@ss.hasPermission('system:sms-template:send-sms')")
    public CommonResult<Long> sendSms(@Valid @RequestBody SmsTemplateSendReqVO sendReqVO) {
        return success(smsSendService.sendSingleSmsToAdmin(sendReqVO.getMobile(), null,
                sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
    }
}
