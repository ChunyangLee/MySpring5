package com.lcy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Repository
public class AccountDAOimpl{
    @Autowired
    private JdbcTemplate jdbcTemplate;


//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void minusBalance(int src_id, double balance) {
        String sql = "update account set `balance`=`balance`-? where id =?";
        int update = jdbcTemplate.update(sql,  balance, src_id);
    }
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void plusBalance(int des_id, double balance) {
        String sql = "update account set `balance`=`balance`+? where id =?";
        int update = jdbcTemplate.update(sql, balance, des_id);
    }
}
