package cn.service;

import cn.entity.Users;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UsersService {
	public int add(Users users);
	public int del(Integer id);
	public int update(Users users);
	public PageInfo<Users> getByMap(Map<String,Object> params);
	public Users getById(Integer id);
	public Users login(String username,String password);
	public Users check(String username);
	public PageInfo<Users> getAllById(Map<String,Object> params);
}
