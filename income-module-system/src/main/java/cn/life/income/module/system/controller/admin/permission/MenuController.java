package cn.life.income.module.system.controller.admin.permission;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.admin.permission.vo.menu.MenuListReqVO;
import cn.life.income.module.system.controller.admin.permission.vo.menu.MenuRespVO;
import cn.life.income.module.system.controller.admin.permission.vo.menu.MenuSaveVO;
import cn.life.income.module.system.controller.admin.permission.vo.menu.MenuSimpleRespVO;
import cn.life.income.module.system.dal.dataobject.permission.MenuDO;
import cn.life.income.module.system.service.permission.MenuService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 菜单管理接口
 */
@RestController
@RequestMapping("/system/menu")
@Validated
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 创建菜单
     * @param createReqVO 菜单创建请求
     * @return 菜单ID
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:menu:create')")
    public CommonResult<Long> createMenu(@Valid @RequestBody MenuSaveVO createReqVO) {
        Long menuId = menuService.createMenu(createReqVO);
        return success(menuId);
    }

    /**
     * 修改菜单
     * @param updateReqVO 菜单更新请求
     * @return 更新结果
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:menu:update')")
    public CommonResult<Boolean> updateMenu(@Valid @RequestBody MenuSaveVO updateReqVO) {
        menuService.updateMenu(updateReqVO);
        return success(true);
    }

    /**
     * 删除菜单
     * @param id 菜单编号
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:menu:delete')")
    public CommonResult<Boolean> deleteMenu(@RequestParam("id") Long id) {
        menuService.deleteMenu(id);
        return success(true);
    }

    /**
     * 批量删除菜单
     * @param ids 菜单编号列表
     * @return 删除结果
     */
    @DeleteMapping("/delete-list")
    @PreAuthorize("@ss.hasPermission('system:menu:delete')")
    public CommonResult<Boolean> deleteMenuList(@RequestParam("ids") List<Long> ids) {
        menuService.deleteMenuList(ids);
        return success(true);
    }

    /**
     * 获取菜单列表
     * @param reqVO 菜单查询条件
     * @return 菜单列表
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:menu:query')")
    public CommonResult<List<MenuRespVO>> getMenuList(MenuListReqVO reqVO) {
        List<MenuDO> list = menuService.getMenuList(reqVO);
        list.sort(Comparator.comparing(MenuDO::getSort));
        return success(BeanUtils.toBean(list, MenuRespVO.class));
    }

    /**
     * 获取菜单精简信息列表
     * @return 菜单精简信息列表
     */
    @GetMapping({"/list-all-simple", "simple-list"})
    public CommonResult<List<MenuSimpleRespVO>> getSimpleMenuList() {
        List<MenuDO> list = menuService.getMenuListByTenant(
                new MenuListReqVO().setStatus(CommonStatusEnum.ENABLE.getStatus()));
        list = menuService.filterDisableMenus(list);
        list.sort(Comparator.comparing(MenuDO::getSort));
        return success(BeanUtils.toBean(list, MenuSimpleRespVO.class));
    }

    /**
     * 获取菜单信息
     * @param id 菜单ID
     * @return 菜单信息
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:menu:query')")
    public CommonResult<MenuRespVO> getMenu(Long id) {
        MenuDO menu = menuService.getMenu(id);
        return success(BeanUtils.toBean(menu, MenuRespVO.class));
    }

}
