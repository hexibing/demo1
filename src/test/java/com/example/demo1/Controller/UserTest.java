package com.example.demo1.Controller;

import redis.clients.jedis.Jedis;

public class UserTest {

    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        // 查看服务是否运行
//        jedis.set("city1", "南京");
//        System.out.println("服务正在运行: " + jedis.ping());
        String s1=jedis.get("myname");
        System.out.println(s1);
    }


}
