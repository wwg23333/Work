package com.gy.jcartadministration.service;

import com.gy.jcartadministration.po.Administrator;

public interface AdminService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

}
