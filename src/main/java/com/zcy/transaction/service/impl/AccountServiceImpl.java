package com.zcy.transaction.service.impl;

import com.zcy.transaction.bean.Account;
import com.zcy.transaction.mapper.AccountMapper;
import com.zcy.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource//查一下意思 和Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = {Exception.class,Error.class})
    @Override
    public void trade(Integer in, Integer out, BigDecimal money) throws Exception {
       Account inner = accountMapper.selectById(in);
       Account outer = accountMapper.selectById(out);

       if(outer.getMoney().compareTo(money) > 0){
           outer.setMoney(outer.getMoney().subtract(money));
       }
       else{
           throw new Exception();
       }
        inner.setMoney(inner.getMoney().add(money));
        accountMapper.updateById(inner);
        accountMapper.updateById((outer));

    }
}
