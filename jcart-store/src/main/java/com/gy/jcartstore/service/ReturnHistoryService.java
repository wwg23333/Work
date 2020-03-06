package com.gy.jcartstore.service;

import com.gy.jcartstore.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);

}
