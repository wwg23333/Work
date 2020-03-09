package com.gy.jcartadministration.service;

import com.gy.jcartadministration.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

}
