package cn.life.income.module.system.controller.admin.dict.vo.data;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.validation.InEnum;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 管理后台 - 字典数据创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示字典数据的创建或修改请求，包括字典数据编号、字典标签、字典值、字典类型等字段。
 * </p>
 */
@Data
public class DictDataSaveReqVO {

    /**
     * 字典数据编号
     * <p>
     * 用于标识字典数据的唯一编号。
     * </p>
     */
    private Long id;

    /**
     * 显示顺序
     * <p>
     * 字典数据在前端展示时的排序顺序。
     * </p>
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * 字典标签
     * <p>
     * 字典项的标签名称，用于标识字典项。
     * </p>
     */
    @NotBlank(message = "字典标签不能为空")
    @Size(max = 100, message = "字典标签长度不能超过100个字符")
    private String label;

    /**
     * 字典值
     * <p>
     * 字典项的实际值，通常与标签一起使用，标识字典项的具体含义。
     * </p>
     */
    @NotBlank(message = "字典键值不能为空")
    @Size(max = 100, message = "字典键值长度不能超过100个字符")
    private String value;

    /**
     * 字典类型
     * <p>
     * 用于区分字典项的类别，如 "sys_common_sex" 表示性别字典。
     * </p>
     */
    @NotBlank(message = "字典类型不能为空")
    @Size(max = 100, message = "字典类型长度不能超过100个字符")
    private String dictType;

    /**
     * 状态
     * <p>
     * 字典数据的状态，参见 {@link CommonStatusEnum} 枚举，表示字典数据是否有效。
     * </p>
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

    /**
     * 颜色类型
     * <p>
     * 字典项的颜色类型，用于在前端展示时设置样式，例如 "default"、"primary" 等。
     * </p>
     */
    private String colorType;

    /**
     * CSS 样式
     * <p>
     * 用于前端展示时为字典项设置的额外 CSS 样式类。
     * </p>
     */
    private String cssClass;

    /**
     * 备注
     * <p>
     * 对字典数据的附加说明，通常用于描述字典项的特殊含义。
     * </p>
     */
    private String remark;
}
