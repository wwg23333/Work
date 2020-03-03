package com.gy.jcartstore.service;

import com.gy.jcartstore.po.Address;

import java.util.List;

public interface AddressService {

    List<Address> getByCustomerId(Integer customerId);

}
