package cn.life.income.module.system.controller.admin.dict.vo.data;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.PageParam;
import cn.life.income.framework.common.validation.InEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Size;

/**
 * 管理后台 - 字典数据分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示字典数据的分页查询请求，包含了字典标签、字典类型、字典状态等字段。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDataPageReqVO extends PageParam {

    /**
     * 字典标签
     * <p>
     * 用于模糊匹配字典项的标签，最大长度为100字符。
     * </p>
     */
    @Size(max = 100, message = "字典标签长度不能超过100个字符")
    private String label;

    /**
     * 字典类型
     * <p>
     * 用于模糊匹配字典项的类型，最大长度为100字符。例如，"sys_common_sex" 表示性别类型。
     * </p>
     */
    @Size(max = 100, message = "字典类型长度不能超过100个字符")
    private String dictType;

    /**
     * 展示状态
     * <p>
     * 字典数据的展示状态，参见 {@link CommonStatusEnum} 枚举。表示字典项是否显示。
     * </p>
     */
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;
}
