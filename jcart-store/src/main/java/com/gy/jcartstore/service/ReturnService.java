package com.gy.jcartstore.service;

import com.github.pagehelper.Page;
import com.gy.jcartstore.po.Return;

public interface ReturnService {

    Return getById(Integer returnId);

    Page<Return> showList(Integer customerId, Integer pageNum);

    Integer reApply(Return re);
}
