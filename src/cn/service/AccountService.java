package cn.service;


import cn.entity.Account;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AccountService {
	public int add(Account account);
	public int del(Integer id);
	public int update(Account account);
	public PageInfo<Account> getByUid(Map<String,Object> params);
	public Account getById(Integer id);
}
