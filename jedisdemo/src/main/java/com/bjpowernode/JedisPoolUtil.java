package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author:whr 2019/9/26
 */
public class JedisPoolUtil {

    public static JedisPool jedisPool;

    // 初始化jedisPool
    static {
        JedisPoolConfig config = new JedisPoolConfig();

        // 设置redis服务器的ip地址
        String host = "192.168.64.135";

        // 设置redis的端口号
        int port = 6379;

        // 设置pool中最多容纳jedis数量
        config.setMaxTotal(10);

        // 设置空闲数
        config.setMaxIdle(3);

        // 设置检查项，确定从pool中取出的jedis对象时可用的
        config.setTestOnBorrow(true);

        // 赋值给static变量jedisPool
        jedisPool = new JedisPool(config, host, port, 6000);
    }


    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


    /**
     * 关闭jedisPool
     */
    public synchronized static void closePool() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }

}
