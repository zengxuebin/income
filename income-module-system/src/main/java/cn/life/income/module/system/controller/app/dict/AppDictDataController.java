package cn.life.income.module.system.controller.app.dict;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.framework.common.util.object.BeanUtils;
import cn.life.income.module.system.controller.app.dict.vo.AppDictDataRespVO;
import cn.life.income.module.system.dal.dataobject.dict.DictDataDO;
import cn.life.income.module.system.service.dict.DictDataService;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 字典数据
 */
@RestController
@RequestMapping("/system/dict-data")
@Validated
public class AppDictDataController {

    @Resource
    private DictDataService dictDataService;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param type 字典类型
     * @return 字典数据列表
     */
    @GetMapping("/type")
    @PermitAll
    public CommonResult<List<AppDictDataRespVO>> getDictDataListByType(@RequestParam("type") String type) {
        List<DictDataDO> list = dictDataService.getDictDataList(
                CommonStatusEnum.ENABLE.getStatus(), type);
        return success(BeanUtils.toBean(list, AppDictDataRespVO.class));
    }
}
