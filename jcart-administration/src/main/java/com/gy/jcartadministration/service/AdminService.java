package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.po.Administrator;

public interface AdminService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

    Page<Administrator> getList(Integer pageNum);

    Integer create(Administrator administrator);
}
