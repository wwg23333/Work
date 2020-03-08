package com.gy.jcartstore.controller;

import com.github.pagehelper.Page;
import com.gy.jcartstore.dto.in.returnn.ReturnSearchInDTO;
import com.gy.jcartstore.dto.in.returnn.ReturnApplyActionInDTO;
import com.gy.jcartstore.dto.out.PageOutDTO;
import com.gy.jcartstore.dto.out.returnn.ReturnHistoryListOutDTO;
import com.gy.jcartstore.dto.out.returnn.ReturnListOutDTO;
import com.gy.jcartstore.dto.out.returnn.ReturnShowOutDTO;
import com.gy.jcartstore.enumeration.ReturnStatus;
import com.gy.jcartstore.po.Return;
import com.gy.jcartstore.po.ReturnHistory;
import com.gy.jcartstore.service.ReturnHistoryService;
import com.gy.jcartstore.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(@RequestAttribute Integer customerId,
                                               @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Return> page = returnService.showList(customerId, pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(returnListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnHistories = returnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);

        return returnShowOutDTO;
    }

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyActionInDTO returnApplyActionInDTO,
                      @RequestAttribute Integer customerId){
        Return re = new Return();
        re.setOrderId(returnApplyActionInDTO.getOrderId());
        re.setOrderTime(new Date(returnApplyActionInDTO.getOrderTimestamp()));
        re.setCustomerId(customerId);
        re.setCustomerName(returnApplyActionInDTO.getCustomerName());
        re.setMobile(returnApplyActionInDTO.getMobile());
        re.setEmail(returnApplyActionInDTO.getEmail());
        re.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        re.setProductCode(returnApplyActionInDTO.getProductCode());
        re.setProductName(returnApplyActionInDTO.getProductName());
        re.setQuantity(returnApplyActionInDTO.getQuantity());
        re.setReason(returnApplyActionInDTO.getReason());
        re.setOpened(returnApplyActionInDTO.getOpened());
        re.setComment(returnApplyActionInDTO.getComment());
        Date now = new Date();
        re.setCreateTime(now);
        re.setUpdateTime(now);
        returnService.reApply(re);
        Integer returnId = re.getReturnId();

        return returnId;
    }

}
