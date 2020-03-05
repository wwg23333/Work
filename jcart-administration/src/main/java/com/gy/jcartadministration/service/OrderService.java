package com.gy.jcartadministration.service;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.out.order.OrderListOutDTO;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

}
