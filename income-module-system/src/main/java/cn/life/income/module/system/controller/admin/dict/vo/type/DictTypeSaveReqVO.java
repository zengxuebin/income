package cn.life.income.module.system.controller.admin.dict.vo.type;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 管理后台 - 字典类型创建/修改 Request VO
 */
@Data
public class DictTypeSaveReqVO {

    /**
     * 字典类型编号
     * 示例值: 1024
     */
    private Long id;

    /**
     * 字典名称
     * 示例值: 性别
     * 必填，且长度不能超过100个字符
     */
    @NotBlank(message = "字典名称不能为空")
    @Size(max = 100, message = "字典类型名称长度不能超过100个字符")
    private String name;

    /**
     * 字典类型
     * 示例值: sys_common_sex
     * 必填，且长度不能超过100个字符
     */
    @NotNull(message = "字典类型不能为空")
    @Size(max = 100, message = "字典类型类型长度不能超过 100 个字符")
    private String type;

    /**
     * 状态，参见 CommonStatusEnum 枚举类
     * 示例值: 1
     * 必填
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 备注
     * 示例值: 快乐的备注
     */
    private String remark;

}
