package cn.life.income.module.infra.controller.app.file.vo;

import cn.life.income.module.infra.controller.admin.file.vo.file.FileUploadReqVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户 App - 上传文件请求参数
 */
@Data
public class AppFileUploadReqVO {

    /**
     * 文件附件
     *
     * @param file 上传的文件
     * @throws IllegalArgumentException 如果文件为空
     */
    @NotNull(message = "文件附件不能为空")
    private MultipartFile file;

    /**
     * 文件目录
     *
     * @param directory 文件目录，默认为空（可选）
     */
    private String directory;

    /**
     * 校验文件目录是否有效
     *
     * @return true 如果文件目录格式正确，false 否则
     */
    @AssertTrue(message = "文件目录不正确")
    @JsonIgnore
    public boolean isDirectoryValid() {
        return FileUploadReqVO.isDirectoryValid(directory);
    }

}
