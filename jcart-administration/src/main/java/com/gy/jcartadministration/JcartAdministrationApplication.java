package com.gy.jcartadministration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gy.jcartadministration.dao")
public class JcartAdministrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartAdministrationApplication.class, args);
    }

}
