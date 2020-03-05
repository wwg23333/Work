package com.gy.jcartadministration.service;

import com.gy.jcartadministration.po.Address;

import java.util.List;

public interface AddressService {

    List<Address> getByCustomerId(Integer customerId);

    Address getById(Integer addressId);
}
