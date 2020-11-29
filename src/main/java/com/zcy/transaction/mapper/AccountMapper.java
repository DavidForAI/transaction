package com.zcy.transaction.mapper;

import com.zcy.transaction.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
