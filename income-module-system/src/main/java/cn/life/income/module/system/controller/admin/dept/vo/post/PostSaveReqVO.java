package cn.life.income.module.system.controller.admin.dept.vo.post;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.validation.InEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 管理后台 - 岗位创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示岗位的创建或修改请求，包括岗位名称、岗位编码、显示顺序、状态等字段。
 * </p>
 */
@Data
public class PostSaveReqVO {

    /**
     * 岗位编号
     * <p>
     * 用于标识岗位的唯一编号，创建时可不填，修改时必填。
     * </p>
     */
    private Long id;

    /**
     * 岗位名称
     * <p>
     * 用于表示岗位的名称，不能为空且长度不能超过 50 个字符。
     * </p>
     */
    @NotBlank(message = "岗位名称不能为空")
    @Size(max = 50, message = "岗位名称长度不能超过 50 个字符")
    private String name;

    /**
     * 岗位编码
     * <p>
     * 用于表示岗位的唯一编码，不能为空且长度不能超过 64 个字符。
     * </p>
     */
    @NotBlank(message = "岗位编码不能为空")
    @Size(max = 64, message = "岗位编码长度不能超过64个字符")
    private String code;

    /**
     * 显示顺序
     * <p>
     * 用于表示岗位在列表中的显示顺序，不能为空。
     * </p>
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * 状态
     * <p>
     * 用于表示岗位的状态，参见 {@link CommonStatusEnum} 枚举类，不能为空。
     * </p>
     */
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    /**
     * 备注
     * <p>
     * 用于填写岗位的备注信息，长度不超过 255 个字符。
     * </p>
     */
    private String remark;
}
