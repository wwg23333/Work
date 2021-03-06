package com.gy.jcartadministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gy.jcartadministration.dao.CustomerMapper;
import com.gy.jcartadministration.dto.in.customer.CustomerSearchInDTO;
import com.gy.jcartadministration.dto.in.customer.CustomerSetStatusInDTO;
import com.gy.jcartadministration.dto.out.customer.CustomerListOutDTO;
import com.gy.jcartadministration.dto.out.customer.CustomerShowOutDTO;
import com.gy.jcartadministration.po.Customer;
import com.gy.jcartadministration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<CustomerListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        Page<CustomerListOutDTO> search = customerMapper.search(pageNum);
        return search;
    }


    @Override
    public void disable(Integer customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setStatus((byte) 1);

        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerSetStatusInDTO.getCustomerId());
        customer.setStatus(customerSetStatusInDTO.getStatus());
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
