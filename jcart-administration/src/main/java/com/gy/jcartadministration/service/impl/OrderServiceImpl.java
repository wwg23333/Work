package com.gy.jcartadministration.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gy.jcartadministration.dao.OrderDetailMapper;
import com.gy.jcartadministration.dao.OrderMapper;
import com.gy.jcartadministration.dto.out.order.OrderListOutDTO;
import com.gy.jcartadministration.dto.out.order.OrderShowOutDTO;
import com.gy.jcartadministration.po.Customer;
import com.gy.jcartadministration.po.Order;
import com.gy.jcartadministration.po.OrderDetail;
import com.gy.jcartadministration.service.CustomerService;
import com.gy.jcartadministration.service.OrderService;
import com.gy.jcartadministration.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<OrderListOutDTO> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Integer orderId) {
        return null;
    }

}
