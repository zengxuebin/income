package cn.life.income.module.infra.controller.admin.redis;

import cn.life.income.framework.common.pojo.CommonResult;
import cn.life.income.module.infra.controller.admin.redis.vo.RedisMonitorRespVO;
import cn.life.income.module.infra.convert.redis.RedisConvert;
import jakarta.annotation.Resource;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

import static cn.life.income.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - Redis 监控控制器
 */
@RestController
@RequestMapping("/infra/redis")
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取 Redis 监控信息
     * <p>
     * 通过 RedisCallback 获取 Redis 服务器的统计信息，并构建返回结果。
     * </p>
     *
     * @return CommonResult 包含 Redis 监控信息的响应对象
     */
    @GetMapping("/get-monitor-info")
    @PreAuthorize("@ss.hasPermission('infra:redis:get-monitor-info')")
    public CommonResult<RedisMonitorRespVO> getRedisMonitorInfo() {
        // 获取 Redis 统计信息
        Properties info = stringRedisTemplate.execute((RedisCallback<Properties>) RedisServerCommands::info);
        Long dbSize = stringRedisTemplate.execute(RedisServerCommands::dbSize);
        Properties commandStats = stringRedisTemplate.execute((
                RedisCallback<Properties>) connection -> connection.serverCommands().info("commandstats"));
        assert commandStats != null; // 断言，避免警告
        // 拼接结果返回
        return success(RedisConvert.INSTANCE.build(info, dbSize, commandStats));
    }
}
