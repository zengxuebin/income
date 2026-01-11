package cn.life.income.module.system.controller.admin.notify.vo.template;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 站内信模板分页请求 VO
 * 用于分页查询站内信模板时的请求参数，包括模板编码、名称、状态和创建时间等。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyTemplatePageReqVO extends PageParam {

    /**
     * 模板编码
     * 用于查询特定模板编码的模板
     */
    private String code;

    /**
     * 模板名称
     * 用于查询特定名称的模板
     */
    private String name;

    /**
     * 模板状态，参见 CommonStatusEnum 枚举类
     * 用于查询模板的状态（如启用或禁用）
     */
    private Integer status;

    /**
     * 创建时间
     * 用于查询特定时间范围内创建的模板
     * 格式为：yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
}
