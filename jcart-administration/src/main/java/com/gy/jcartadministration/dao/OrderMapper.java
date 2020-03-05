package com.gy.jcartadministration.dao;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.dto.out.order.OrderListOutDTO;
import com.gy.jcartadministration.po.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order orderId);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search();
}