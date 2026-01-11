package cn.life.income.module.infra.controller.admin.file.vo.file;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 管理后台 - 上传文件 Request VO
 */
@Data
public class FileUploadReqVO {

    /**
     * 文件附件
     *
     * 必须上传文件
     */
    @NotNull(message = "文件附件不能为空")
    private MultipartFile file;

    /**
     * 文件目录
     *
     * 例如：XXX/YYY
     */
    private String directory;

    /**
     * 文件目录是否合法
     *
     * 校验文件目录是否符合要求，目录不能包含 `..`，并且不能以 `/` 或 `\` 开头
     *
     * @return 如果目录有效返回 true，否则返回 false
     */
    @AssertTrue(message = "文件目录不正确")
    @JsonIgnore
    public boolean isDirectoryValid() {
        return isDirectoryValid(directory);
    }

    /**
     * 判断文件目录是否合法
     *
     * 1. 不能包含 `..`，防止目录穿越
     * 2. 不能以 `/` 或 `\` 开头，防止上传到根目录
     *
     * @param directory 文件目录
     * @return 如果目录有效返回 true，否则返回 false
     */
    public static boolean isDirectoryValid(String directory) {
        return !StrUtil.contains(directory, "..")
                && !StrUtil.startWithAny(directory, "/", "\\");
    }
}
