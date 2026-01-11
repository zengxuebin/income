package cn.life.income.module.system.controller.admin.socail.vo.user;

import cn.life.income.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.life.income.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 社交用户分页请求数据传输对象 (Request VO)
 * <p>
 * 该类用于表示管理后台社交用户分页查询的请求参数，支持根据社交平台类型、用户昵称、社交 openid、创建时间等条件进行筛选。
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SocialUserPageReqVO extends PageParam {

    /**
     * 社交平台的类型
     * <p>
     * 用于指定社交平台类型（例如：微信、QQ、微博等）。
     * </p>
     */
    private Integer type;

    /**
     * 用户昵称
     * <p>
     * 用于根据用户的昵称进行模糊查询。
     * </p>
     */
    private String nickname;

    /**
     * 社交 openid
     * <p>
     * 用于指定社交平台的唯一标识符 openid。
     * </p>
     */
    private String openid;

    /**
     * 创建时间范围
     * <p>
     * 用于查询指定时间范围内注册的社交用户，格式为 `[YYYY-MM-DD HH:mm:ss, YYYY-MM-DD HH:mm:ss]`。
     * </p>
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
