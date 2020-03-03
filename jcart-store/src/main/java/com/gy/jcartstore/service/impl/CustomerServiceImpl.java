package com.gy.jcartstore.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gy.jcartstore.dao.CustomerMapper;
import com.gy.jcartstore.dto.in.CustomerRegisterDTO;
import com.gy.jcartstore.enumeration.CustomerStatus;
import com.gy.jcartstore.po.Customer;
import com.gy.jcartstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer register(CustomerRegisterDTO customerRegisterDTO) {

        Customer customer = new Customer();
        customer.setUsername(customerRegisterDTO.getUsername());
        customer.setRealName(customerRegisterDTO.getRealName());
        customer.setEmail(customerRegisterDTO.getEmail());
        customer.setEmailVerified(false);
        customer.setMobile(customerRegisterDTO.getMobile());
        customer.setMobileVerified(false);
        customer.setNewsSubscribed(customerRegisterDTO.getNewsSubscribed());
        customer.setCreateTime(new Date());
        customer.setStatus((byte) CustomerStatus.Enable.ordinal());
        customer.setRewordPoints(0);

        String password = customerRegisterDTO.getPassword();
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);

        customerMapper.insertSelective(customer);
        Integer customerId = customer.getCustomerId();

        return customerId;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
