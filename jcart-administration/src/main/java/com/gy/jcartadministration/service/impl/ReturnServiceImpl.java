package com.gy.jcartadministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gy.jcartadministration.dao.ReturnMapper;
import com.gy.jcartadministration.po.Return;
import com.gy.jcartadministration.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Return getById(Integer returnId) {
        Return re = returnMapper.selectByPrimaryKey(returnId);
        return re;
    }

    @Override
    public Page<Return> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.search();
        return page;
    }

    @Override
    public void update(Return re) {
        returnMapper.updateByPrimaryKeySelective(re);
    }

}
