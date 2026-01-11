package cn.life.income.module.system.controller.admin.sms;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import cn.life.income.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import cn.life.income.module.system.controller.admin.sms.vo.channel.SmsChannelSaveReqVO;
import cn.life.income.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.sms.SmsChannelDO;
import cn.life.income.module.system.service.sms.SmsChannelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 短信渠道 Controller，提供短信渠道的相关操作接口
 */
@RestController
@RequestMapping("system/sms-channel")
public class SmsChannelController {

    @Resource
    private SmsChannelService smsChannelService;

    /**
     * 创建短信渠道
     *
     * @param createReqVO 短信渠道创建请求对象
     * @return 返回创建后的短信渠道 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:create')")
    public CommonResult<Long> createSmsChannel(@Valid @RequestBody SmsChannelSaveReqVO createReqVO) {
        return success(smsChannelService.createSmsChannel(createReqVO));
    }

    /**
     * 更新短信渠道
     *
     * @param updateReqVO 短信渠道更新请求对象
     * @return 返回操作是否成功
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:update')")
    public CommonResult<Boolean> updateSmsChannel(@Valid @RequestBody SmsChannelSaveReqVO updateReqVO) {
        smsChannelService.updateSmsChannel(updateReqVO);
        return success(true);
    }

    /**
     * 删除短信渠道
     *
     * @param id 短信渠道编号
     * @return 返回操作是否成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:delete')")
    public CommonResult<Boolean> deleteSmsChannel(@RequestParam("id") Long id) {
        smsChannelService.deleteSmsChannel(id);
        return success(true);
    }

    /**
     * 批量删除短信渠道
     *
     * @param ids 短信渠道编号列表
     * @return 返回操作是否成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:delete')")
    public CommonResult<Boolean> deleteSmsChannelList(@RequestParam("ids") List<Long> ids) {
        smsChannelService.deleteSmsChannelList(ids);
        return success(true);
    }

    /**
     * 获得指定短信渠道的信息
     *
     * @param id 短信渠道编号
     * @return 返回短信渠道的详细信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:query')")
    public CommonResult<SmsChannelRespVO> getSmsChannel(@RequestParam("id") Long id) {
        SmsChannelDO channel = smsChannelService.getSmsChannel(id);
        return success(BeanUtils.toBean(channel, SmsChannelRespVO.class));
    }

    /**
     * 获取短信渠道分页数据
     *
     * @param pageVO 分页请求对象
     * @return 返回分页数据
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:query')")
    public CommonResult<PageResult<SmsChannelRespVO>> getSmsChannelPage(@Valid SmsChannelPageReqVO pageVO) {
        PageResult<SmsChannelDO> pageResult = smsChannelService.getSmsChannelPage(pageVO);
        return success(BeanUtils.toBean(pageResult, SmsChannelRespVO.class));
    }

    /**
     * 获取所有短信渠道的精简列表
     *
     * @return 返回短信渠道精简信息列表
     */
    @GetMapping({"/list-all-simple", "/simple-list"})
    public CommonResult<List<SmsChannelSimpleRespVO>> getSimpleSmsChannelList() {
        List<SmsChannelDO> list = smsChannelService.getSmsChannelList();
        list.sort(Comparator.comparing(SmsChannelDO::getId));
        return success(BeanUtils.toBean(list, SmsChannelSimpleRespVO.class));
    }
}
