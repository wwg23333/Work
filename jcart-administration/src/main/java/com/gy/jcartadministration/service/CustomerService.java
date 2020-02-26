package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.out.customer.CustomerListOutDTO;
import com.gy.jcartadministration.dto.out.customer.CustomerShowOutDTO;

public interface CustomerService {

    Page<CustomerListOutDTO> search(Integer pageNum);
    void disable(Integer customerId);
    CustomerShowOutDTO getById(Integer customerId);
}
