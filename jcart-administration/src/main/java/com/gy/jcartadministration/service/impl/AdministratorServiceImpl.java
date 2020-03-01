package com.gy.jcartadministration.service.impl;

import com.gy.jcartadministration.dao.AdministratorMapper;
import com.gy.jcartadministration.po.Administrator;
import com.gy.jcartadministration.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdminService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }
    }
}
