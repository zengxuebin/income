package cn.life.income.module.system.controller.admin.user.vo.profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import lombok.Data;

/**
 * 管理后台 - 用户个人信息更新请求数据传输对象 (User Profile Update Request VO)
 * <p>
 * 该类用于管理后台更新用户个人信息时传递的请求参数。
 * </p>
 */
@Data
public class UserProfileUpdateReqVO {

    /**
     * 用户昵称
     * <p>
     * 用户昵称的长度不能超过 30 个字符。
     * </p>
     */
    @Size(max = 30, message = "用户昵称长度不能超过 30 个字符")
    private String nickname;

    /**
     * 用户邮箱
     * <p>
     * 邮箱的格式必须正确，并且长度不能超过 50 个字符。
     * </p>
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    /**
     * 手机号码
     * <p>
     * 手机号码长度必须为 11 位。
     * </p>
     */
    @Length(min = 11, max = 11, message = "手机号长度必须 11 位")
    private String mobile;

    /**
     * 用户性别
     * <p>
     * 性别字段的值参见 SexEnum 枚举类。
     * </p>
     */
    private Integer sex;

    /**
     * 角色头像
     * <p>
     * 头像地址必须是一个有效的 URL。
     * </p>
     */
    @URL(message = "头像地址格式不正确")
    private String avatar;
}
