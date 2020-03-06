package com.gy.jcartadministration.service.impl;

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

}
