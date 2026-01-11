package cn.life.income.module.infra.controller.admin.file.vo.file;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileRespVO {

    /**
     * 文件编号
     */
    private Long id;

    /**
     * 配置编号
     */
    private Long configId;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 原文件名
     */
    private String name;

    /**
     * 文件 URL
     */
    private String url;

    /**
     * 文件MIME类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
