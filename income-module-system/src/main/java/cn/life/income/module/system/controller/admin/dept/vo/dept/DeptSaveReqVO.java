package cn.life.income.module.system.controller.admin.dept.vo.dept;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.validation.InEnum;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 管理后台 - 部门创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示部门的创建或修改请求信息，包括部门名称、父部门、负责人、联系电话等字段。
 * </p>
 */
@Data
public class DeptSaveReqVO {

    /**
     * 部门编号
     * <p>
     * 该字段用于指定要创建或修改的部门编号，若为创建则无需传入。
     * </p>
     */
    private Long id;

    /**
     * 部门名称
     * <p>
     * 部门名称不能为空，且长度不能超过 30 个字符。
     * </p>
     */
    @NotBlank(message = "部门名称不能为空")
    @Size(max = 30, message = "部门名称长度不能超过 30 个字符")
    private String name;

    /**
     * 父部门 ID
     * <p>
     * 可为空，若该部门为顶级部门，则无需填写该字段。
     * </p>
     */
    private Long parentId;

    /**
     * 显示顺序
     * <p>
     * 部门在列表中的显示顺序，不能为空。
     * </p>
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * 负责人的用户编号
     * <p>
     * 可为空，若该部门没有负责人则无需填写。
     * </p>
     */
    private Long leaderUserId;

    /**
     * 联系电话
     * <p>
     * 可为空，但若填写则需要符合格式要求，且长度不能超过 11 个字符。
     * </p>
     */
    @Size(max = 11, message = "联系电话长度不能超过 11 个字符")
    private String phone;

    /**
     * 邮箱
     * <p>
     * 可为空，若填写则必须符合邮箱格式，且长度不能超过 50 个字符。
     * </p>
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    /**
     * 状态
     * <p>
     * 该字段表示部门的当前状态，值必须是 {@link CommonStatusEnum} 中的有效值，不能为空。
     * </p>
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

}
