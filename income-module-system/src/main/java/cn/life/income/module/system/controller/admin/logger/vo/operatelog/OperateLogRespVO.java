package cn.life.income.module.system.controller.admin.logger.vo.operatelog;

import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.module.system.dal.dataobject.user.AdminUserDO;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import cn.life.income.module.system.enums.DictTypeConstants;
import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.VO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 操作日志 Response VO
 */
@Data
@ExcelIgnoreUnannotated
public class OperateLogRespVO implements VO {

    /** 日志编号 */
    @ExcelProperty("日志编号")
    private Long id;

    /** 链路追踪编号 */
    private String traceId;

    /** 用户编号 */
    @Trans(type = TransType.SIMPLE, target = AdminUserDO.class, fields = "nickname", ref = "userName")
    private Long userId;

    /** 用户昵称 */
    @ExcelProperty("操作人")
    private String userName;

    /** 用户类型 */
    @ExcelProperty("用户类型")
    @DictFormat(DictTypeConstants.USER_TYPE)
    private Integer userType;

    /** 操作模块类型 */
    @ExcelProperty("操作模块类型")
    private String type;

    /** 操作名 */
    @ExcelProperty("操作名")
    private String subType;

    /** 操作模块业务编号 */
    @ExcelProperty("操作模块业务编号")
    private Long bizId;

    /** 操作明细 */
    private String action;

    /** 拓展字段 */
    private String extra;

    /** 请求方法名 */
    @NotEmpty(message = "请求方法名不能为空")
    private String requestMethod;

    /** 请求地址 */
    private String requestUrl;

    /** 用户 IP */
    private String userIp;

    /** 浏览器 UserAgent */
    private String userAgent;

    /** 创建时间 */
    private LocalDateTime createTime;

}
