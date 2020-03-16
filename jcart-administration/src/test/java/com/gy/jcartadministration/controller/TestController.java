package com.gy.jcartadministration.controller;

import com.gy.jcartadministration.exception.ClientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestController {
    @Autowired
    private AdminController adminController;

    @Test
    void loginSuccess() throws ClientException {
    }

    @Test
    void loginWrongUsername(){

    }


    @Test
    void loginWrongPassword(){

    }

}
