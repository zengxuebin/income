package cn.life.income.module.system.controller.admin.oauth2;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.pojo.PageResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.oauth2.vo.token.OAuth2AccessTokenPageReqVO;
import cn.life.income.module.system.controller.admin.oauth2.vo.token.OAuth2AccessTokenRespVO;
import cn.life.income.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import cn.life.income.module.system.enums.logger.LoginLogTypeEnum;
import cn.life.income.module.system.service.auth.AdminAuthService;
import cn.life.income.module.system.service.oauth2.OAuth2TokenService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - OAuth2.0 令牌控制器
 * 该控制器提供了与 OAuth2.0 令牌相关的操作，如获取令牌分页、删除令牌等。
 */
@RestController
@RequestMapping("/system/oauth2-token")
public class OAuth2TokenController {

    @Resource
    private OAuth2TokenService oauth2TokenService;
    @Resource
    private AdminAuthService authService;

    /**
     * 获取访问令牌分页信息
     *
     * @param reqVO 请求对象，包含分页信息和筛选条件
     * @return 返回分页后的 OAuth2 访问令牌信息
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:oauth2-token:page')")
    public CommonResult<PageResult<OAuth2AccessTokenRespVO>> getAccessTokenPage(@Valid OAuth2AccessTokenPageReqVO reqVO) {
        PageResult<OAuth2AccessTokenDO> pageResult = oauth2TokenService.getAccessTokenPage(reqVO);
        return success(BeanUtils.toBean(pageResult, OAuth2AccessTokenRespVO.class));
    }

    /**
     * 删除指定的访问令牌
     *
     * @param accessToken 访问令牌的值
     * @return 删除操作是否成功
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:oauth2-token:delete')")
    public CommonResult<Boolean> deleteAccessToken(@RequestParam("accessToken") String accessToken) {
        authService.logout(accessToken, LoginLogTypeEnum.LOGOUT_DELETE.getType());
        return success(true);
    }

    /**
     * 批量删除指定的访问令牌
     *
     * @param accessTokens 访问令牌数组
     * @return 批量删除操作是否成功
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:oauth2-token:delete')")
    public CommonResult<Boolean> deleteAccessTokenList(@RequestParam("accessTokens") List<String> accessTokens) {
        accessTokens.forEach(accessToken ->
                authService.logout(accessToken, LoginLogTypeEnum.LOGOUT_DELETE.getType()));
        return success(true);
    }

}
