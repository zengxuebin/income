package cn.life.income.module.system.controller.admin.notify.vo.message;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 站内信分页请求 VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyMessagePageReqVO extends PageParam {

    /**
     * 用户编号
     * 用于查询特定用户的站内信
     */
    private Long userId;

    /**
     * 用户类型
     * 可根据用户类型筛选站内信，参见 UserTypeEnum 枚举类
     */
    private Integer userType;

    /**
     * 模板编码
     * 用于根据模板筛选站内信
     */
    private String templateCode;

    /**
     * 模版类型
     * 用于根据模板类型筛选站内信
     */
    private Integer templateType;

    /**
     * 创建时间范围
     * 用于筛选在指定时间范围内创建的站内信
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
