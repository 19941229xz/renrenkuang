package com.example.renrenkuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.example.renrenkuang.dao")
public class RenrenkuangApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenrenkuangApplication.class, args);
    }

}
