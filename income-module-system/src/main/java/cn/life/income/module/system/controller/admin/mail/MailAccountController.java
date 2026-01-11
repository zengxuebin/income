package cn.life.income.module.system.controller.admin.mail;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.life.income.module.system.controller.admin.mail.vo.account.MailAccountRespVO;
import cn.life.income.module.system.controller.admin.mail.vo.account.MailAccountSaveReqVO;
import cn.life.income.module.system.controller.admin.mail.vo.account.MailAccountSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.mail.MailAccountDO;
import cn.life.income.module.system.service.mail.MailAccountService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 邮箱账号
 */
@RestController
@RequestMapping("/system/mail-account")
public class MailAccountController {

    @Resource
    private MailAccountService mailAccountService;

    /**
     * 创建邮箱账号
     *
     * @param createReqVO 邮箱账号创建请求参数
     * @return 返回创建的邮箱账号 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:mail-account:create')")
    public CommonResult<Long> createMailAccount(@Valid @RequestBody MailAccountSaveReqVO createReqVO) {
        return success(mailAccountService.createMailAccount(createReqVO));
    }

    /**
     * 修改邮箱账号
     *
     * @param updateReqVO 邮箱账号更新请求参数
     * @return 更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:mail-account:update')")
    public CommonResult<Boolean> updateMailAccount(@Valid @RequestBody MailAccountSaveReqVO updateReqVO) {
        mailAccountService.updateMailAccount(updateReqVO);
        return success(true);
    }

    /**
     * 删除邮箱账号
     *
     * @param id 邮箱账号编号
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteMailAccount(@RequestParam Long id) {
        mailAccountService.deleteMailAccount(id);
        return success(true);
    }

    /**
     * 批量删除邮箱账号
     *
     * @param ids 邮箱账号编号列表
     * @return 批量删除结果
     */
    @DeleteMapping("/delete-list")
    public CommonResult<Boolean> deleteMailAccountList(@RequestParam("ids") List<Long> ids) {
        mailAccountService.deleteMailAccountList(ids);
        return success(true);
    }

    /**
     * 获得邮箱账号
     *
     * @param id 邮箱账号编号
     * @return 邮箱账号响应对象
     */
    @GetMapping("/get")
    public CommonResult<MailAccountRespVO> getMailAccount(@RequestParam("id") Long id) {
        MailAccountDO account = mailAccountService.getMailAccount(id);
        return success(BeanUtils.toBean(account, MailAccountRespVO.class));
    }

    /**
     * 获得邮箱账号分页
     *
     * @param pageReqVO 分页请求参数
     * @return 分页结果
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-account:query')")
    public CommonResult<PageResult<MailAccountRespVO>> getMailAccountPage(@Valid MailAccountPageReqVO pageReqVO) {
        PageResult<MailAccountDO> pageResult = mailAccountService.getMailAccountPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MailAccountRespVO.class));
    }

    /**
     * 获得邮箱账号精简列表
     *
     * @return 邮箱账号简化响应列表
     */
    @GetMapping({"/list-all-simple", "simple-list"})
    public CommonResult<List<MailAccountSimpleRespVO>> getSimpleMailAccountList() {
        List<MailAccountDO> list = mailAccountService.getMailAccountList();
        return success(BeanUtils.toBean(list, MailAccountSimpleRespVO.class));
    }

}
