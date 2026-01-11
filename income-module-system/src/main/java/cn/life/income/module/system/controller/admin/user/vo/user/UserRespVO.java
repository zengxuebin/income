package cn.life.income.module.system.controller.admin.user.vo.user;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * 管理后台 - 用户信息 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class UserRespVO {

    /**
     * 用户编号
     * 必填项，不能为空
     */
    @ExcelProperty("用户编号")
    private Long id;

    /**
     * 用户账号
     * 必填项，不能为空
     */
    @ExcelProperty("用户名称")
    private String username;

    /**
     * 用户昵称
     * 必填项，不能为空
     */
    @ExcelProperty("用户昵称")
    private String nickname;

    /**
     * 备注
     * 例如：我是一个用户
     */
    private String remark;

    /**
     * 部门ID
     * 例如：部门ID
     */
    private Long deptId;

    /**
     * 部门名称
     * 例如：IT 部
     */
    @ExcelProperty("部门名称")
    private String deptName;

    /**
     * 岗位编号数组
     * 例如：岗位编号
     */
    private Set<Long> postIds;

    /**
     * 用户邮箱
     * 例如：income@iocoder.cn
     */
    @ExcelProperty("用户邮箱")
    private String email;

    /**
     * 手机号码
     * 例如：15601691300
     */
    @ExcelProperty("手机号码")
    private String mobile;

    /**
     * 用户性别，参见 SexEnum 枚举类
     * 例如：1 表示男性
     */
    @ExcelProperty(value = "用户性别", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_SEX)
    private Integer sex;

    /**
     * 用户头像
     * 例如：https://www.iocoder.cn/xxx.png
     */
    private String avatar;

    /**
     * 状态，参见 CommonStatusEnum 枚举类
     * 必填项，不能为空
     */
    @ExcelProperty(value = "帐号状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 最后登录 IP
     * 例如：192.168.1.1
     */
    @ExcelProperty("最后登录IP")
    private String loginIp;

    /**
     * 最后登录时间
     * 例如：时间戳格式
     */
    @ExcelProperty("最后登录时间")
    private LocalDateTime loginDate;

    /**
     * 创建时间
     * 例如：时间戳格式
     */
    private LocalDateTime createTime;
}
