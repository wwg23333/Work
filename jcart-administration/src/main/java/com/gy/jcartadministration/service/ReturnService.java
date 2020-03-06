package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.po.Return;

public interface ReturnService {
    Return getById(Integer returnId);

    Page<Return> search(Integer pageNum);
}
