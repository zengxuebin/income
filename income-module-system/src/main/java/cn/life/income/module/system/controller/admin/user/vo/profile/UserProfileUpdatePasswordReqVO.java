package cn.life.income.module.system.controller.admin.user.vo.profile;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 管理后台 - 用户个人中心更新密码请求数据传输对象 (User Profile Update Password Request VO)
 * <p>
 * 该类用于管理后台更新用户个人中心密码时传递的请求参数。
 * </p>
 */
@Data
public class UserProfileUpdatePasswordReqVO {

    /**
     * 旧密码
     * <p>
     * 旧密码不能为空，并且长度必须在 4 到 16 个字符之间。
     * </p>
     */
    @NotEmpty(message = "旧密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String oldPassword;

    /**
     * 新密码
     * <p>
     * 新密码不能为空，并且长度必须在 4 到 16 个字符之间。
     * </p>
     */
    @NotEmpty(message = "新密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String newPassword;

}
