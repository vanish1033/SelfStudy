package com.bjpowernode;

import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * @author:whr 2019/9/26
 */
public class Test {

    @org.junit.Test
    public void test() {
        Jedis jedis = JedisPoolUtil.getJedis();
        jedis.set("jedis", new Date().toString());

        if (jedis != null) {
            jedis.close();
        }

    }

}
