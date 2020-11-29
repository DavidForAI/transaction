package com.zcy.transaction.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
class TradeServiceImplTest {

    @Resource
    private AccountServiceImpl accountService;

    @Test
    public void trade(){
       try {
           accountService.trade(1, 2, BigDecimal.valueOf(5000.1234));
       }catch (Exception ex){
           System.out.println("trade failed");
       }
    }

}