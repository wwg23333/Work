package com.gy.jcartstore.service;

import com.gy.jcartstore.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

}
