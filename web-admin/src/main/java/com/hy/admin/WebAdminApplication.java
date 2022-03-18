package com.hy.admin;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hy.admin.mapper")
@SpringBootApplication
public class WebAdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }

}
