package com.gy.jcartstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.gy.jcartstore.dao.OrderMapper;
import com.gy.jcartstore.dto.in.OrderCheckoutInDTO;
import com.gy.jcartstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                         Integer customerId) {

        return null;
    }
}
