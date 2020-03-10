package com.gy.jcartadministration.service.impl;

import com.gy.jcartadministration.dao.ReturnHistoryMapper;
import com.gy.jcartadministration.po.Return;
import com.gy.jcartadministration.po.ReturnHistory;
import com.gy.jcartadministration.service.ReturnHistoryService;
import com.gy.jcartadministration.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectListByReturnId(returnId);
        return returnHistories;
    }

    @Override
    @Transactional
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return re = new Return();
        re.setReturnId(returnHistory.getReturnId());
        re.setUpdateTime(new Date());
        returnService.update(re);

        return returnHistoryId;
    }
}
