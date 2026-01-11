package cn.life.income.module.system.controller.admin.sms.vo.template;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

/**
 * 管理后台 - 短信模板的发送 Request VO
 */
@Data
public class SmsTemplateSendReqVO {

    /**
     * 手机号
     * 示例值：15601691300
     * 必填项
     */
    @NotNull(message = "手机号不能为空")
    private String mobile;

    /**
     * 模板编码
     * 示例值：test_01
     * 必填项
     */
    @NotNull(message = "模板编码不能为空")
    private String templateCode;

    /**
     * 模板参数
     * 例：{"name": "张三", "code": "1234"}
     */
    private Map<String, Object> templateParams;

}
