package cn.life.income.module.system.controller.admin.dept.vo.post;

import cn.life.income.framework.common.enums.CommonStatusEnum;
import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理后台 - 岗位分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示岗位分页查询的请求参数，包括岗位编码、岗位名称、展示状态等字段。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostPageReqVO extends PageParam {

    /**
     * 岗位编码
     * <p>
     * 用于模糊匹配岗位编码，支持根据岗位编码进行查询。
     * </p>
     */
    private String code;

    /**
     * 岗位名称
     * <p>
     * 用于模糊匹配岗位名称，支持根据岗位名称进行查询。
     * </p>
     */
    private String name;

    /**
     * 展示状态
     * <p>
     * 用于查询岗位的展示状态，参见 {@link CommonStatusEnum} 枚举类，支持状态过滤。
     * </p>
     */
    private Integer status;
}
