package cn.life.income.module.infra.controller.app.file;

import cn.hutool.core.io.IoUtil;
import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.module.infra.controller.admin.file.vo.file.FileCreateReqVO;
import cn.life.income.module.infra.controller.admin.file.vo.file.FilePreSignedUrlRespVO;
import cn.life.income.module.infra.controller.app.file.vo.AppFileUploadReqVO;
import cn.life.income.module.infra.service.file.FileService;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 用户 App - 文件存储管理
 */
@RestController
@RequestMapping("/infra/file")
@Validated
@Slf4j
public class AppFileController {

    @Resource
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param uploadReqVO 文件上传请求参数，包含文件和上传目录等信息
     * @return 返回上传结果，包括文件的唯一标识
     * @throws Exception 如果文件处理失败
     */
    @PostMapping("/upload")
    public CommonResult<String> uploadFile(AppFileUploadReqVO uploadReqVO) throws Exception {
        MultipartFile file = uploadReqVO.getFile();
        byte[] content = IoUtil.readBytes(file.getInputStream());
        return success(fileService.createFile(content, file.getOriginalFilename(),
                uploadReqVO.getDirectory(), file.getContentType()));
    }

    /**
     * 获取文件预签名地址（用于文件上传）
     *
     * @param name 文件名称
     * @param directory 文件目录（可选）
     * @return 返回文件上传的预签名 URL
     */
    @GetMapping("/presigned-url")
    public CommonResult<FilePreSignedUrlRespVO> getFilePresignedUrl(
            @RequestParam("name") String name,
            @RequestParam(value = "directory", required = false) String directory) {
        return success(fileService.presignPutUrl(name, directory));
    }

    /**
     * 创建文件记录（用于记录通过预签名 URL 上传的文件）
     *
     * @param createReqVO 创建文件请求参数，包括文件的元数据
     * @return 返回创建的文件 ID
     */
    @PostMapping("/create")
    @PermitAll
    public CommonResult<Long> createFile(@Valid @RequestBody FileCreateReqVO createReqVO) {
        return success(fileService.createFile(createReqVO));
    }
}
