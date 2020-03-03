package com.gy.jcartstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gy.jcartstore.dao")
public class JcartStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartStoreApplication.class, args);
    }

}
