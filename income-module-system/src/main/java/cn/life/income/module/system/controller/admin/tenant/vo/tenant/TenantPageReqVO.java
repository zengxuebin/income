package cn.life.income.module.system.controller.admin.tenant.vo.tenant;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 管理后台 - 租户分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于管理后台进行租户分页查询时传递的请求参数。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPageReqVO extends PageParam {

    /**
     * 租户名
     * <p>
     * 租户的名称，支持模糊匹配。
     * </p>
     */
    private String name;

    /**
     * 联系人
     * <p>
     * 租户的联系人姓名，支持模糊匹配。
     * </p>
     */
    private String contactName;

    /**
     * 联系手机
     * <p>
     * 租户联系人的手机号码，支持模糊匹配。
     * </p>
     */
    private String contactMobile;

    /**
     * 租户状态
     * <p>
     * 租户的状态，0表示正常，1表示停用，支持状态筛选。
     * </p>
     */
    private Integer status;

    /**
     * 创建时间
     * <p>
     * 租户的创建时间范围，支持时间筛选，格式为"yyyy-MM-dd HH:mm:ss"。
     * </p>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}
