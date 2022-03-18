package com.hy.admin.service.serviceImpl;

import com.hy.admin.mapper.AccountMapper;
import com.hy.admin.bean.Account;
import com.hy.admin.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/14 19:32
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAcctById(Integer id){
        return accountMapper.getAcct(id);
    }


}
