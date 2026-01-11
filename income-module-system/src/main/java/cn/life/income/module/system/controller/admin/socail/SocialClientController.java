package cn.life.income.module.system.controller.admin.socail;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.api.social.SocialClientApi;
import cn.life.income.module.system.api.social.dto.SocialWxaSubscribeMessageSendReqDTO;
import cn.life.income.module.system.controller.admin.socail.vo.client.SocialClientPageReqVO;
import cn.life.income.module.system.controller.admin.socail.vo.client.SocialClientRespVO;
import cn.life.income.module.system.controller.admin.socail.vo.client.SocialClientSaveReqVO;
import cn.life.income.module.system.dal.dataobject.social.SocialClientDO;
import cn.life.income.module.system.service.social.SocialClientService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 社交客户端
 */
@RestController
@RequestMapping("/system/social-client")
@Validated
public class SocialClientController {

    @Resource
    private SocialClientService socialClientService;
    @Resource
    private SocialClientApi socialClientApi;

    /**
     * 创建社交客户端
     * @param createReqVO 创建请求对象
     * @return 返回创建的社交客户端ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:social-client:create')")
    public CommonResult<Long> createSocialClient(@Valid @RequestBody SocialClientSaveReqVO createReqVO) {
        return success(socialClientService.createSocialClient(createReqVO));
    }

    /**
     * 更新社交客户端
     * @param updateReqVO 更新请求对象
     * @return 返回更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:social-client:update')")
    public CommonResult<Boolean> updateSocialClient(@Valid @RequestBody SocialClientSaveReqVO updateReqVO) {
        socialClientService.updateSocialClient(updateReqVO);
        return success(true);
    }

    /**
     * 删除社交客户端
     * @param id 社交客户端ID
     * @return 返回删除结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:social-client:delete')")
    public CommonResult<Boolean> deleteSocialClient(@RequestParam("id") Long id) {
        socialClientService.deleteSocialClient(id);
        return success(true);
    }

    /**
     * 批量删除社交客户端
     * @param ids 社交客户端ID列表
     * @return 返回删除结果
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:social-client:delete')")
    public CommonResult<Boolean> deleteSocialClientList(@RequestParam("ids") List<Long> ids) {
        socialClientService.deleteSocialClientList(ids);
        return success(true);
    }

    /**
     * 获取社交客户端详情
     * @param id 社交客户端ID
     * @return 返回社交客户端详情
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:social-client:query')")
    public CommonResult<SocialClientRespVO> getSocialClient(@RequestParam("id") Long id) {
        SocialClientDO client = socialClientService.getSocialClient(id);
        return success(BeanUtils.toBean(client, SocialClientRespVO.class));
    }

    /**
     * 获取社交客户端分页列表
     * @param pageVO 分页请求对象
     * @return 返回社交客户端分页数据
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:social-client:query')")
    public CommonResult<PageResult<SocialClientRespVO>> getSocialClientPage(@Valid SocialClientPageReqVO pageVO) {
        PageResult<SocialClientDO> pageResult = socialClientService.getSocialClientPage(pageVO);
        return success(BeanUtils.toBean(pageResult, SocialClientRespVO.class));
    }

    /**
     * 发送订阅消息 (用于测试)
     * @param reqDTO 订阅消息请求对象
     */
    @PostMapping("/send-subscribe-message")
    @PreAuthorize("@ss.hasPermission('system:social-client:query')")
    public void sendSubscribeMessage(@RequestBody SocialWxaSubscribeMessageSendReqDTO reqDTO) {
        socialClientApi.sendWxaSubscribeMessage(reqDTO);
    }

}
