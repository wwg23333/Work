package com.gy.jcartstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gy.jcartstore.dao.ProductDetailMapper;
import com.gy.jcartstore.dao.ProductMapper;
import com.gy.jcartstore.dto.out.product.ProductListOutDTO;
import com.gy.jcartstore.dto.out.product.ProductShowOutDTO;
import com.gy.jcartstore.po.Product;
import com.gy.jcartstore.po.ProductDetail;
import com.gy.jcartstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<ProductListOutDTO> page = productMapper.search();
        return page;
    }
}
