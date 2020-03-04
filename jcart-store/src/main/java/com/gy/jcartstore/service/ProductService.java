package com.gy.jcartstore.service;


import com.github.pagehelper.Page;
import com.gy.jcartstore.dto.out.product.ProductListOutDTO;
import com.gy.jcartstore.dto.out.product.ProductShowOutDTO;
import com.gy.jcartstore.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);



}
