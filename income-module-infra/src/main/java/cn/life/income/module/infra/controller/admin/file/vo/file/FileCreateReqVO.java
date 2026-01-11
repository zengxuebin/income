package cn.life.income.module.infra.controller.admin.file.vo.file;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 管理后台 - 文件创建 Request VO
 */
@Data
public class FileCreateReqVO {

    /**
     * 文件配置编号
     * 例如：11
     */
    @NotNull(message = "文件配置编号不能为空")
    private Long configId;

    /**
     * 文件路径
     * 例如：income.jpg
     */
    @NotNull(message = "文件路径不能为空")
    private String path;

    /**
     * 原文件名
     * 例如：income.jpg
     */
    @NotNull(message = "原文件名不能为空")
    private String name;

    /**
     * 文件 URL
     * 例如：<a href="https://www.iocoder.cn/income.jpg">...</a>
     */
    @NotNull(message = "文件 URL不能为空")
    private String url;

    /**
     * 文件 MIME 类型
     * 例如：application/octet-stream
     */
    private String type;

    /**
     * 文件大小
     * 例如：2048
     */
    private Integer size;

}