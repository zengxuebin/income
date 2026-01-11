package cn.life.income.module.system.controller.admin.logger.vo.loginlog;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 登录日志 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class LoginLogRespVO {

    /**
     * 日志编号
     * 示例值: 1024
     */
    @ExcelProperty("日志主键")
    private Long id;

    /**
     * 日志类型，参见 LoginLogTypeEnum 枚举类
     * 示例值: 1
     */
    @ExcelProperty(value = "日志类型", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_TYPE)
    private Integer logType;

    /**
     * 用户编号
     * 示例值: 666
     */
    private Long userId;

    /**
     * 用户类型，参见 UserTypeEnum 枚举
     * 示例值: 2
     */
    private Integer userType;

    /**
     * 链路追踪编号
     * 示例值: 89aca178-a370-411c-ae02-3f0d672be4ab
     */
    private String traceId;

    /**
     * 用户账号
     * 示例值: income
     */
    @ExcelProperty("用户账号")
    private String username;

    /**
     * 登录结果，参见 LoginResultEnum 枚举类
     * 示例值: 1
     */
    @ExcelProperty(value = "登录结果", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.LOGIN_RESULT)
    private Integer result;

    /**
     * 用户 IP
     * 示例值: 127.0.0.1
     */
    @ExcelProperty("登录 IP")
    private String userIp;

    /**
     * 浏览器 UserAgent
     * 示例值: Mozilla/5.0
     */
    @ExcelProperty("浏览器 UA")
    private String userAgent;

    /**
     * 登录时间
     */
    @ExcelProperty("登录时间")
    private LocalDateTime createTime;

}
