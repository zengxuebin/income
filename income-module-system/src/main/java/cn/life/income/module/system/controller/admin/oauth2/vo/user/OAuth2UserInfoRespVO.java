package cn.life.income.module.system.controller.admin.oauth2.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 管理后台 - OAuth2 获得用户基本信息 Response VO
 *
 * 返回用户的基本信息，包括用户编号、账号、昵称、邮箱、手机等信息，
 * 还包括所在部门和所属岗位的信息。
 *
 * @author zengxuebin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2UserInfoRespVO {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户性别，参见 SexEnum 枚举类
     */
    private Integer sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 所在部门
     */
    private Dept dept;

    /**
     * 所属岗位数组
     */
    private List<Post> posts;

    /**
     * 部门信息
     */
    @Data
    public static class Dept {

        /**
         * 部门编号
         */
        private Long id;

        /**
         * 部门名称
         */
        private String name;

    }

    /**
     * 岗位信息
     */
    @Data
    public static class Post {

        /**
         * 岗位编号
         */
        private Long id;

        /**
         * 岗位名称
         */
        private String name;

    }

}
