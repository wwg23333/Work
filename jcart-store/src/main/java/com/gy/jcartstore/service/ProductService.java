package com.gy.jcartstore.service;


import com.github.pagehelper.Page;
import com.gy.jcartstore.dto.out.product.ProductListOutDTO;
import com.gy.jcartstore.dto.out.product.ProductShowOutDTO;

public interface ProductService {

    Page<ProductListOutDTO> search(Integer pageNum);

}
