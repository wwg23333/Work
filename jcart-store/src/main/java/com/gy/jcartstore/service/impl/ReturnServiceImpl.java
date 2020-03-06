package com.gy.jcartstore.service.impl;

import com.gy.jcartstore.dao.ReturnMapper;
import com.gy.jcartstore.po.Return;
import com.gy.jcartstore.service.ReturnService;
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
}
