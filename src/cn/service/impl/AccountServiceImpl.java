package cn.service.impl;

import cn.dao.AccountMapper;
import cn.entity.Account;
import cn.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public int add(Account account) {//生成预约单
        return accountMapper.insert(account);
    }

    @Override
    public int del(Integer id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Account account) {
        return accountMapper.updateByPrimaryKeySelective(account);
    }


    @Override
    public PageInfo<Account> getByUid(Map params) {
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Account> accountList=null;
        accountList=accountMapper.getByUid(params);
        return new PageInfo<Account>(accountList);
    }

    @Override
    public Account getById(Integer id) {
        return accountMapper.selectByPrimaryKey(id);
    }

}
