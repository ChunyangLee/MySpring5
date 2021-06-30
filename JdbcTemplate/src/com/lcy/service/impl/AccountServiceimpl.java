package com.lcy.service.impl;

import com.lcy.dao.impl.AccountDAOimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccountServiceimpl {

    @Autowired
    private AccountDAOimpl accountDAOimpl;

    public void transfer(int src_id, int des_id, double balance){
        //找到src和des的id，完成转账
        accountDAOimpl.minusBalance(src_id,balance);
//        int i=10/0;
        accountDAOimpl.plusBalance(des_id,balance);
    }


}

