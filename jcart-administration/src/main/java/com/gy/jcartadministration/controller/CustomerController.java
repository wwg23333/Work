package com.gy.jcartadministration.controller;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.in.customer.CustomerSearchInDTO;
import com.gy.jcartadministration.dto.in.customer.CustomerSetStatusInDTO;
import com.gy.jcartadministration.dto.out.PageOutDTO;
import com.gy.jcartadministration.dto.out.customer.CustomerListOutDTO;
import com.gy.jcartadministration.dto.out.customer.CustomerShowOutDTO;
import com.gy.jcartadministration.po.Customer;
import com.gy.jcartadministration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO, @RequestParam Integer pageNum){
        Page<CustomerListOutDTO> customerListOutPage = customerService.search(pageNum);
        PageOutDTO<CustomerListOutDTO> page = new PageOutDTO<>();
        page.setPageSize(customerListOutPage.getPageSize());
        page.setPageNum(customerListOutPage.getPageNum());
        page.setTotal(customerListOutPage.getTotal());
        page.setList(customerListOutPage);
        return page;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId) {
        Customer customer = customerService.getById(customerId);

        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customerId);
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());

        return customerShowOutDTO;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){
        customerService.disable(customerId);
    }

    @PostMapping("/setStatus")
    public void setStatus(@RequestBody CustomerSetStatusInDTO customerSetStatusInDTO){
        customerService.setStatus(customerSetStatusInDTO);
    }


}
