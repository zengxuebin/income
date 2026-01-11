package cn.life.income.module.system.controller.admin.oauth2;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.oauth2.vo.client.OAuth2ClientPageReqVO;
import cn.life.income.module.system.controller.admin.oauth2.vo.client.OAuth2ClientRespVO;
import cn.life.income.module.system.controller.admin.oauth2.vo.client.OAuth2ClientSaveReqVO;
import cn.life.income.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import cn.life.income.module.system.service.oauth2.OAuth2ClientService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - OAuth2 客户端控制器
 * 处理所有与 OAuth2 客户端相关的请求，包括创建、更新、删除、查询等操作。
 */
@Validated
@RestController
@RequestMapping("/system/oauth2-client")
public class OAuth2ClientController {

    @Resource
    private OAuth2ClientService oAuth2ClientService;

    /**
     * 创建 OAuth2 客户端
     *
     * @param createReqVO 创建 OAuth2 客户端的请求数据
     * @return 返回创建的 OAuth2 客户端 ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:create')")
    public CommonResult<Long> createOAuth2Client(@Valid @RequestBody OAuth2ClientSaveReqVO createReqVO) {
        return success(oAuth2ClientService.createOAuth2Client(createReqVO));
    }

    /**
     * 更新 OAuth2 客户端
     *
     * @param updateReqVO 更新 OAuth2 客户端的请求数据
     * @return 返回更新是否成功的标志
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:update')")
    public CommonResult<Boolean> updateOAuth2Client(@Valid @RequestBody OAuth2ClientSaveReqVO updateReqVO) {
        oAuth2ClientService.updateOAuth2Client(updateReqVO);
        return success(true);
    }

    /**
     * 删除 OAuth2 客户端
     *
     * @param id OAuth2 客户端的 ID
     * @return 返回删除是否成功的标志
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:delete')")
    public CommonResult<Boolean> deleteOAuth2Client(@RequestParam("id") Long id) {
        oAuth2ClientService.deleteOAuth2Client(id);
        return success(true);
    }

    /**
     * 批量删除 OAuth2 客户端
     *
     * @param ids OAuth2 客户端的 ID 列表
     * @return 返回批量删除是否成功的标志
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:delete')")
    public CommonResult<Boolean> deleteOAuth2ClientList(@RequestParam("ids") List<Long> ids) {
        oAuth2ClientService.deleteOAuth2ClientList(ids);
        return success(true);
    }

    /**
     * 获取 OAuth2 客户端
     *
     * @param id OAuth2 客户端的 ID
     * @return 返回 OAuth2 客户端的详细信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:query')")
    public CommonResult<OAuth2ClientRespVO> getOAuth2Client(@RequestParam("id") Long id) {
        OAuth2ClientDO client = oAuth2ClientService.getOAuth2Client(id);
        return success(BeanUtils.toBean(client, OAuth2ClientRespVO.class));
    }

    /**
     * 获取 OAuth2 客户端分页数据
     *
     * @param pageVO 分页查询参数
     * @return 返回分页数据
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:query')")
    public CommonResult<PageResult<OAuth2ClientRespVO>> getOAuth2ClientPage(@Valid OAuth2ClientPageReqVO pageVO) {
        PageResult<OAuth2ClientDO> pageResult = oAuth2ClientService.getOAuth2ClientPage(pageVO);
        return success(BeanUtils.toBean(pageResult, OAuth2ClientRespVO.class));
    }
}
