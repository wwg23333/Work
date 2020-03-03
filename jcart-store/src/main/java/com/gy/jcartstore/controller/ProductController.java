package com.gy.jcartstore.controller;

import com.github.pagehelper.Page;
import com.gy.jcartstore.dto.in.product.ProductSearchInDTO;
import com.gy.jcartstore.dto.out.PageOutDTO;
import com.gy.jcartstore.dto.out.product.ProductListOutDTO;
import com.gy.jcartstore.dto.out.product.ProductShowOutDTO;
import com.gy.jcartstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,@RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

}
