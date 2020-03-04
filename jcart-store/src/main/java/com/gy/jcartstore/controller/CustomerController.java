package com.gy.jcartstore.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gy.jcartstore.constant.ClientExceptionConstant;
import com.gy.jcartstore.dto.in.*;
import com.gy.jcartstore.dto.out.*;
import com.gy.jcartstore.exception.ClientException;
import com.gy.jcartstore.po.Customer;
import com.gy.jcartstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //用户注册页面
    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterDTO customerRegisterInDTO){
        Integer customerId = customerService.register(customerRegisterInDTO);
        return customerId;
    }

    //用户登录页面
    @GetMapping("/login")
    public String login(CustomerLoginDTO customerLoginDTO){
        return null;
    }

    //获取编辑页信息
    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerGetProfileOutDTO customerGetProfileOutDTO = new CustomerGetProfileOutDTO();
        customerGetProfileOutDTO.setUsername(customer.getUsername());
        customerGetProfileOutDTO.setRealName(customer.getRealName());
        customerGetProfileOutDTO.setMobile(customer.getMobile());
        customerGetProfileOutDTO.setMobileVerified(customer.getMobileVerified());
        customerGetProfileOutDTO.setEmail(customer.getEmail());
        customerGetProfileOutDTO.setEmailVerified(customer.getEmailVerified());

        return customerGetProfileOutDTO;
    }
    //编辑页面
    @PostMapping("/updateProdfile")
    public void updatePro(@RequestBody CustomerUpdateProfileDTO customerUpdateProfileDTO,
                          @RequestAttribute Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setRealName(customerUpdateProfileDTO.getRealName());
        customer.setMobile(customerUpdateProfileDTO.getMobile());
        customer.setEmail(customerUpdateProfileDTO.getEmail());
        customerService.update(customer);

    }

    //重置新的密码
    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId) throws ClientException {
        Customer customer = customerService.getById(customerId);
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdInDTO.getOriginPwd().toCharArray(), encPwdDB);

        if (result.verified) {
            String newPwd = customerChangePwdInDTO.getNewPwd();
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
            customer.setEncryptedPassword(bcryptHashString);
            customerService.update(customer);
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }

    }

    @GetMapping("/getPwdRestCode")
    public String getPwdRest(@RequestParam String email){
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
