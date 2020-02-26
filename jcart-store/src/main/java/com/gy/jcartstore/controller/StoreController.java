package com.gy.jcartstore.controller;

import com.gy.jcartstore.dto.in.StoreUpdateProfileDTO;
import com.gy.jcartstore.dto.out.StoreGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interviewProduct")
public class StoreController {

    @GetMapping("/search")
    public String product(@RequestParam String product_name,@RequestParam String product_code){
            return null;
    }

    @GetMapping("/addproduct")
    public String addProduct(){
        return null;
    }

    @GetMapping("/getProduct")
    public StoreGetProfileOutDTO getProfile(Integer productId){
        return null;
    }

    @PostMapping("/updateProduct")
    public void updatePro(@RequestBody StoreUpdateProfileDTO storeUpdateProfileDTO){

    }

}
