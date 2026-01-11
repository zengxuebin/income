package cn.life.income.module.system.controller.admin.user.vo.user;

import cn.hutool.core.util.ObjectUtil;
import cn.life.income.framework.common.validation.Mobile;
import cn.life.income.module.system.framework.operatelog.core.DeptParseFunction;
import cn.life.income.module.system.framework.operatelog.core.PostParseFunction;
import cn.life.income.module.system.framework.operatelog.core.SexParseFunction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

/**
 * 管理后台 - 用户创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于管理后台进行用户创建或修改时传递的请求参数。
 * </p>
 */
@Data
public class UserSaveReqVO {

    /**
     * 用户编号
     * <p>
     * 用于标识用户的唯一编号，仅在修改时使用。
     * </p>
     */
    private Long id;

    /**
     * 用户账号
     * <p>
     * 账号由字母和数字组成，长度在 4-30 个字符之间，且不能为空。
     * </p>
     */
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    @DiffLogField(name = "用户账号")
    private String username;

    /**
     * 用户昵称
     * <p>
     * 昵称长度不超过 30 个字符。
     * </p>
     */
    @Size(max = 30, message = "用户昵称长度不能超过30个字符")
    @DiffLogField(name = "用户昵称")
    private String nickname;

    /**
     * 备注
     * <p>
     * 对用户的备注信息，长度不限。
     * </p>
     */
    @DiffLogField(name = "备注")
    private String remark;

    /**
     * 部门编号
     * <p>
     * 用户所属的部门编号，仅在修改时使用。
     * </p>
     */
    @DiffLogField(name = "部门", function = DeptParseFunction.NAME)
    private Long deptId;

    /**
     * 岗位编号数组
     * <p>
     * 用户所属的岗位编号集合，仅在修改时使用。
     * </p>
     */
    @DiffLogField(name = "岗位", function = PostParseFunction.NAME)
    private Set<Long> postIds;

    /**
     * 用户邮箱
     * <p>
     * 邮箱地址，格式必须正确且长度不超过 50 个字符。
     * </p>
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    @DiffLogField(name = "用户邮箱")
    private String email;

    /**
     * 手机号码
     * <p>
     * 用户的手机号码，必须符合手机号码格式。
     * </p>
     */
    @Mobile
    @DiffLogField(name = "手机号码")
    private String mobile;

    /**
     * 用户性别
     * <p>
     * 用户的性别，参见 SexEnum 枚举类，值为 1 或 2 等。
     * </p>
     */
    @DiffLogField(name = "用户性别", function = SexParseFunction.NAME)
    private Integer sex;

    /**
     * 用户头像
     * <p>
     * 用户头像的 URL 地址，支持上传头像并提供头像链接。
     * </p>
     */
    @DiffLogField(name = "用户头像")
    private String avatar;

    // ========== 仅【创建】时，需要传递的字段 ==========

    /**
     * 密码
     * <p>
     * 用户密码，长度应在 4-16 位之间，并且仅在创建时需要传递。
     * </p>
     */
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

    /**
     * 校验密码是否有效
     * <p>
     * 用于确保在修改时无需提供密码，而在创建时必须提供密码。
     * </p>
     */
    @AssertTrue(message = "密码不能为空")
    @JsonIgnore
    public boolean isPasswordValid() {
        return id != null // 修改时，不需要传递
                || (ObjectUtil.isAllNotEmpty(password)); // 新增时，必须都传递 password
    }

}
