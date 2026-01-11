package cn.life.income.module.infra.controller.admin.codegen.vo.table;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 表定义分页 Request VO
 */
@Data
public class CodegenTablePageReqVO extends PageParam {

    /**
     * 表名称，模糊匹配
     */
    private String tableName;

    /**
     * 表描述，模糊匹配
     */
    private String tableComment;

    /**
     * 实体，模糊匹配
     */
    private String className;

    /**
     * 创建时间
     * 格式： [2022-07-01 00:00:00,2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;
}
