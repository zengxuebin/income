package cn.life.income.module.infra.controller.admin.redis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Properties;

/**
 * 管理后台 - Redis 监控信息响应 VO
 */
@Data
@Builder
@AllArgsConstructor
public class RedisMonitorRespVO {

    /**
     * Redis info 指令结果，具体字段请参考 Redis 文档
     */
    private Properties info;

    /**
     * Redis key 数量
     * 示例值: 1024
     */
    private Long dbSize;

    /**
     * Redis 命令统计数组
     */
    private List<CommandStat> commandStats;

    /**
     * Redis 命令统计信息
     */
    @Data
    @Builder
    @AllArgsConstructor
    public static class CommandStat {

        /**
         * Redis 命令名称
         * 示例值: "get"
         */
        private String command;

        /**
         * Redis 命令调用次数
         * 示例值: 1024
         */
        private Long calls;

        /**
         * Redis 命令消耗的 CPU 时间（秒）
         * 示例值: 666
         */
        private Long usec;
    }
}
