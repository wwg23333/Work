package com.gy.jcartstore.service.impl;

import com.gy.jcartstore.po.OrderHistory;
import com.gy.jcartstore.service.OrderHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        return null;
    }
}
