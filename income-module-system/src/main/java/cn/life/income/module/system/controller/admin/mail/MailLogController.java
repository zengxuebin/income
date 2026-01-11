package cn.life.income.module.system.controller.admin.mail;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.mail.vo.log.MailLogPageReqVO;
import cn.life.income.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import cn.life.income.module.system.dal.dataobject.mail.MailLogDO;
import cn.life.income.module.system.service.mail.MailLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 邮件日志
 */
@RestController
@RequestMapping("/system/mail-log")
public class MailLogController {

    @Resource
    private MailLogService mailLogService;

    /**
     * 获得邮箱日志分页
     *
     * 根据请求的分页条件返回邮箱日志的分页数据。
     *
     * @param pageVO 分页请求参数
     * @return 分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-log:query')")
    public CommonResult<PageResult<MailLogRespVO>> getMailLogPage(@Valid MailLogPageReqVO pageVO) {
        PageResult<MailLogDO> pageResult = mailLogService.getMailLogPage(pageVO);
        return success(BeanUtils.toBean(pageResult, MailLogRespVO.class));
    }

    /**
     * 获得邮箱日志
     *
     * 根据邮箱日志的编号查询单条日志信息。
     *
     * @param id 日志编号
     * @return 邮箱日志详情
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:mail-log:query')")
    public CommonResult<MailLogRespVO> getMailTemplate(@RequestParam("id") Long id) {
        MailLogDO log = mailLogService.getMailLog(id);
        return success(BeanUtils.toBean(log, MailLogRespVO.class));
    }
}
