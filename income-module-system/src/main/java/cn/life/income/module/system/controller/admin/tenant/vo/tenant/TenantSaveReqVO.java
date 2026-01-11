package cn.life.income.module.system.controller.admin.tenant.vo.tenant;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - 租户创建/修改请求数据传输对象 (Request VO)
 * <p>
 * 该类用于管理后台进行租户创建或修改的请求，包含租户相关信息如租户名、联系人、套餐、过期时间等。
 * </p>
 */
@Data
public class TenantSaveReqVO {

    /**
     * 租户编号
     * <p>
     * 用于标识租户的唯一编号，仅在修改时需要传递。
     * </p>
     */
    private Long id;

    /**
     * 租户名
     * <p>
     * 租户的名称，不能为空。
     * </p>
     */
    @NotNull(message = "租户名不能为空")
    private String name;

    /**
     * 联系人
     * <p>
     * 租户的联系人姓名，不能为空。
     * </p>
     */
    @NotNull(message = "联系人不能为空")
    private String contactName;

    /**
     * 联系手机
     * <p>
     * 租户联系人的手机号码，可选。
     * </p>
     */
    private String contactMobile;

    /**
     * 租户状态
     * <p>
     * 租户的状态，不能为空，通常为启用或禁用。
     * </p>
     */
    @NotNull(message = "租户状态")
    private Integer status;

    /**
     * 绑定域名数组
     * <p>
     * 租户绑定的域名，允许多个域名绑定。
     * </p>
     */
    private List<String> websites;

    /**
     * 租户套餐编号
     * <p>
     * 租户所属的套餐编号，不能为空。
     * </p>
     */
    @NotNull(message = "租户套餐编号不能为空")
    private Long packageId;

    /**
     * 过期时间
     * <p>
     * 租户的过期时间，不能为空，表示租户的有效期。
     * </p>
     */
    @NotNull(message = "过期时间不能为空")
    private LocalDateTime expireTime;

    /**
     * 账号数量
     * <p>
     * 租户允许创建的账号数量，不能为空。
     * </p>
     */
    @NotNull(message = "账号数量不能为空")
    private Integer accountCount;

    // ========== 仅【创建】时，需要传递的字段 ==========

    /**
     * 用户账号
     * <p>
     * 租户管理员的用户名，4到30个字符，仅允许数字和字母，不能为空，仅在创建时需要传递。
     * </p>
     */
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    /**
     * 密码
     * <p>
     * 租户管理员的密码，长度为4到16位，不能为空，仅在创建时需要传递。
     * </p>
     */
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

    /**
     * 验证创建时用户账号和密码的合法性
     * <p>
     * 新增租户时，必须传递 `username` 和 `password`，修改租户时，`username` 和 `password` 不需要传递。
     * </p>
     * @return 是否合法
     */
    @AssertTrue(message = "用户账号、密码不能为空")
    @JsonIgnore
    public boolean isUsernameValid() {
        return id != null // 修改时，不需要传递
                || (ObjectUtil.isAllNotEmpty(username, password)); // 新增时，必须都传递 username、password
    }

}
