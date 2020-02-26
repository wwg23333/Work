package com.gy.jcartstore.controller;

import com.gy.jcartstore.dto.in.*;
import com.gy.jcartstore.dto.out.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    //用户注册页面
    @PostMapping("/register")
    public void  register(@RequestBody CustomerRegisterDTO customerRegisterDTO){

    }

    //用户登录页面
    @GetMapping("/login")
    public String login(CustomerLoginDTO customerLoginDTO){
        return null;
    }

    //获取编辑页信息
    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestParam(required = false) Integer customerId){
        return null;
    }
    //编辑页面
    @PostMapping("/updateProdfile")
    public void updatePro(@RequestBody CustomerUpdateProfileDTO customerUpdateProfileDTO){

    }
    //传入重置的密码
    @GetMapping("/getPwdRestCode")
    public String getPwdRest(@RequestParam String email){
        return null;
    }

    //重置新的密码
    @PostMapping("/restPwd")
    public void restPwd(@RequestBody CustomerRestPwdInDTO customerRestPwdInDTO){

    }

    //获取列表
    @GetMapping("/UserList")
    public PageOutDTO<CustomerListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getBYId(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody CustomerCreateInDTO customerId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody CustomerUpdateInDTO customerUpdateInDTO){

    }

}
