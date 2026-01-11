package cn.life.income.module.system.controller.admin.auth.vo;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 管理后台 - 注册请求数据传输对象 (Register Request VO)
 * <p>
 * 该类用于管理后台注册时传递的请求参数。
 * </p>
 */
@Data
public class AuthRegisterReqVO {

    /**
     * 用户账号
     * <p>
     * 账号由数字和字母组成，长度应在 4-30 个字符之间，不能为空。
     * </p>
     */
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    /**
     * 用户昵称
     * <p>
     * 用户昵称不能为空，且长度不能超过 30 个字符。
     * </p>
     */
    @NotBlank(message = "用户昵称不能为空")
    @Size(max = 30, message = "用户昵称长度不能超过 30 个字符")
    private String nickname;

    /**
     * 密码
     * <p>
     * 密码不能为空，且长度为 4-16 位。
     * </p>
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;
}
