package com.gy.jcartstore.controller;

import com.gy.jcartstore.dto.in.returnn.ReturnSearchInDTO;
import com.gy.jcartstore.dto.in.returnn.ReturnApplyActionInDTO;
import com.gy.jcartstore.dto.out.PageOutDTO;
import com.gy.jcartstore.dto.out.returnn.ReturnListOutDTO;
import com.gy.jcartstore.dto.out.returnn.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/apply")
    public void apply(@RequestBody ReturnApplyActionInDTO returnApplyActionInDTO){

    }

}
