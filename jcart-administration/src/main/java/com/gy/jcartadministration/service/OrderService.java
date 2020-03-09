package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.out.order.OrderListOutDTO;
import com.gy.jcartadministration.dto.out.order.OrderShowOutDTO;
import com.gy.jcartadministration.po.Order;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);

}
