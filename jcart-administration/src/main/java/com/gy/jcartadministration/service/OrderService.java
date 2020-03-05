package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.out.order.OrderListOutDTO;
import com.gy.jcartadministration.dto.out.order.OrderShowOutDTO;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

}
