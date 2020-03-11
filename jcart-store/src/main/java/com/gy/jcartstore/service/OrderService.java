package com.gy.jcartstore.service;

import com.github.pagehelper.Page;
import com.gy.jcartstore.dto.in.OrderCheckoutInDTO;
import com.gy.jcartstore.dto.out.OrderShowOutDTO;
import com.gy.jcartstore.po.Order;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
