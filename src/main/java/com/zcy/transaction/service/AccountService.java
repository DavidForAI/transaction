package com.zcy.transaction.service;

import java.math.BigDecimal;

public interface AccountService {

    void trade(Integer in, Integer out, BigDecimal money) throws Exception;
}
