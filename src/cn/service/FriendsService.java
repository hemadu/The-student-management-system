package cn.service;


import cn.entity.Friends;
import cn.entity.Users;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FriendsService {
	public int add(Friends friends);
	public int del(Integer id);
	public int update(Friends friends);
	public Friends getById(Integer id);
	public PageInfo<Friends> getByUid(Map<String,Object> params);
}
