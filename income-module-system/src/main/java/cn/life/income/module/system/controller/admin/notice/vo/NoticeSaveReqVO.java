package cn.life.income.module.system.controller.admin.notice.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 管理后台 - 通知公告创建/修改请求 VO
 */
@Data
public class NoticeSaveReqVO {

    /**
     * 岗位公告编号
     */
    private Long id;

    /**
     * 公告标题
     * 必须填写，且最多 50 个字符
     */
    @NotBlank(message = "公告标题不能为空")
    @Size(max = 50, message = "公告标题不能超过50个字符")
    private String title;

    /**
     * 公告类型
     * 必须填写
     */
    @NotNull(message = "公告类型不能为空")
    private Integer type;

    /**
     * 公告内容
     * 必须填写
     */
    private String content;

    /**
     * 状态，参见 CommonStatusEnum 枚举类
     * 必须填写
     */
    private Integer status;

}
