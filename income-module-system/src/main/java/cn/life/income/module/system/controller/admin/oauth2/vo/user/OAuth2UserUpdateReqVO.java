package cn.life.income.module.system.controller.admin.oauth2.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * 管理后台 - OAuth2 更新用户基本信息 Request VO
 *
 * 用于接收前端提交的用户更新请求，包括用户的昵称、邮箱、手机号码和性别等信息。
 *
 * @author zengxuebin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2UserUpdateReqVO {

    /**
     * 用户昵称
     * 用户昵称的长度不能超过 30 个字符
     */
    @Size(max = 30, message = "用户昵称长度不能超过 30 个字符")
    private String nickname;

    /**
     * 用户邮箱
     * 邮箱格式必须正确，且长度不能超过 50 个字符
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    /**
     * 手机号码
     * 手机号码长度必须为 11 位
     */
    @Length(min = 11, max = 11, message = "手机号长度必须 11 位")
    private String mobile;

    /**
     * 用户性别，参见 SexEnum 枚举类
     */
    private Integer sex;

}
