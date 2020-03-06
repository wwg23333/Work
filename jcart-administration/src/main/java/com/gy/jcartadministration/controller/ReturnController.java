package com.gy.jcartadministration.controller;

import com.gy.jcartadministration.dto.in.returnn.ReturnSearchInDTO;
import com.gy.jcartadministration.dto.in.returnn.ReturnUpdateActionInDTO;
import com.gy.jcartadministration.dto.out.PageOutDTO;
import com.gy.jcartadministration.dto.out.returnn.ReturnListOutDTO;
import com.gy.jcartadministration.dto.out.returnn.ReturnShowOutDTO;
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

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }

}
