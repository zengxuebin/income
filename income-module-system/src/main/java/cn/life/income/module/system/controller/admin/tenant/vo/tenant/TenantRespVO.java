package cn.life.income.module.system.controller.admin.tenant.vo.tenant;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import cn.life.income.framework.excel.core.annotations.DictFormat;
import cn.life.income.framework.excel.core.convert.DictConvert;
import cn.life.income.module.system.enums.DictTypeConstants;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ExcelIgnoreUnannotated
public class TenantRespVO {

    /**
     * 租户编号
     */
    @ExcelProperty("租户编号")
    private Long id;

    /**
     * 租户名
     */
    @ExcelProperty("租户名")
    private String name;

    /**
     * 联系人
     */
    @ExcelProperty("联系人")
    private String contactName;

    /**
     * 联系手机
     */
    @ExcelProperty("联系手机")
    private String contactMobile;

    /**
     * 租户状态
     */
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    /**
     * 绑定域名数组
     */
    private List<String> websites;

    /**
     * 租户套餐编号
     */
    private Long packageId;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 账号数量
     */
    private Integer accountCount;

    /**
     * 创建时间
     */
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
