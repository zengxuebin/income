package cn.life.income.module.infra.controller.admin.file.vo.file;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 文件分页 Request VO
 */
@Data
public class FilePageReqVO extends PageParam {

    /**
     * 文件路径，模糊匹配
     * 例如：income
     */
    private String path;

    /**
     * 文件类型，模糊匹配
     * 例如：jpg
     */
    private String type;

    /**
     * 创建时间
     * 例如：[2022-07-01 00:00:00, 2022-07-01 23:59:59]
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
