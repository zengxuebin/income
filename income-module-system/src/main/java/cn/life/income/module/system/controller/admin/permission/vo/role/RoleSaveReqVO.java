package cn.life.income.module.system.controller.admin.permission.vo.role;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.validation.InEnum;
import com.mzt.logapi.starter.annotation.DiffLogField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 管理后台 - 角色创建/更新请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示创建或更新角色的请求，包括角色的基本信息、显示顺序、状态等。
 * </p>
 */
@Data
public class RoleSaveReqVO {

    /**
     * 角色编号
     * <p>
     * 用于指定更新某个已存在的角色。创建时不必提供该字段。
     * </p>
     */
    private Long id;

    /**
     * 角色名称
     * <p>
     * 用于指定角色的名称，不能为空且长度不得超过 30 个字符。
     * </p>
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 30, message = "角色名称长度不能超过 30 个字符")
    @DiffLogField(name = "角色名称")
    private String name;

    /**
     * 角色标志
     * <p>
     * 用于指定角色的标志，不能为空且长度不得超过 100 个字符。
     * </p>
     */
    @NotBlank(message = "角色标志不能为空")
    @Size(max = 100, message = "角色标志长度不能超过 100 个字符")
    @DiffLogField(name = "角色标志")
    private String code;

    /**
     * 显示顺序
     * <p>
     * 用于指定角色的显示顺序，不能为空。
     * </p>
     */
    @NotNull(message = "显示顺序不能为空")
    @DiffLogField(name = "显示顺序")
    private Integer sort;

    /**
     * 状态
     * <p>
     * 用于指定角色的状态，参见 `CommonStatusEnum` 枚举，不能为空。
     * </p>
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "状态必须是 {value}")
    @DiffLogField(name = "状态")
    private Integer status;

    /**
     * 备注
     * <p>
     * 用于指定角色的备注信息，长度不得超过 500 个字符。
     * </p>
     */
    @Size(max = 500, message = "备注长度不能超过 500 个字符")
    @DiffLogField(name = "备注")
    private String remark;

}
