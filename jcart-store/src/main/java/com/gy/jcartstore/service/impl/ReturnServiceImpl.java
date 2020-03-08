package com.gy.jcartstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public Page<Return> showList(Integer customerId, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.showList(customerId);
        return page;
    }

    @Override
    public Integer reApply(Return re) {
        returnMapper.insertSelective(re);
        Integer returnId = re.getReturnId();
        return returnId;
    }
}
