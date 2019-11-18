package com.imooc.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

//事务：要么全部执行，要么都不执行
@Service
public class LuckymoneyService {
    @Autowired
    private LuckmoneyRepository repository;
    @Transactional
    public void createTwo()
    {
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setProducer("付金");
        luckymoney.setMoney(new BigDecimal("520"));
        repository.save(luckymoney);
        Luckymoney luckymoneyTwo=new Luckymoney();
        luckymoneyTwo.setProducer("林伟健");
        luckymoneyTwo.setMoney(new BigDecimal("1314"));
        repository.save(luckymoneyTwo);


    }
}
