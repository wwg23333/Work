package com.gy.jcartadministration.service.impl;

import com.gy.jcartadministration.dao.AddressMapper;
import com.gy.jcartadministration.po.Address;
import com.gy.jcartadministration.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        return addresses;
    }
}
