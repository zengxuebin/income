package cn.life.income.module.system.controller.admin.mail.vo.template;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 邮件模板分页请求对象
 *
 * 用于分页查询邮件模板的请求参数，包括模板状态、标识、名称、账号编号等信息。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailTemplatePageReqVO extends PageParam {

    /**
     * 状态
     *
     * 邮件模板的状态，参见 `CommonStatusEnum` 枚举。例如：1表示启用，0表示禁用。
     */
    private Integer status;

    /**
     * 标识
     *
     * 邮件模板的编号或标识，支持模糊匹配查询。
     */
    private String code;

    /**
     * 名称
     *
     * 邮件模板的名称，支持模糊匹配查询。
     */
    private String name;

    /**
     * 账号编号
     *
     * 关联的邮箱账号编号，用户可以按此字段过滤模板。
     */
    private Long accountId;

    /**
     * 创建时间
     *
     * 邮件模板的创建时间范围，支持时间区间查询。
     * 使用格式 `yyyy-MM-dd HH:mm:ss`。
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
}
