package com.example.tongzhiserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.tongzhiserver.mapper")
public class TongZhiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TongZhiServerApplication.class, args);
    }

}
