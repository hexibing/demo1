package com.bingo.lucklybaby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bingo.lucklybaby.mapper")
public class LucklyBabyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LucklyBabyApplication.class, args);
    }

}
