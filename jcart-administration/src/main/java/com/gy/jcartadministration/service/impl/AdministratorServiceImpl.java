package com.gy.jcartadministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Administrator> page = administratorMapper.selectList();
        return page;
    }
}
