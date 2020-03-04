package com.gy.jcartstore.service;

import com.gy.jcartstore.dto.in.CustomerRegisterDTO;
import com.gy.jcartstore.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterDTO customerRegisterDTO);

    Customer getById(Integer customerId);

    void update(Customer customer);

    Customer getByEmail(String email);

}
