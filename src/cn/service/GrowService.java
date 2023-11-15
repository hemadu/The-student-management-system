package cn.service;


import cn.entity.Grow;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GrowService {
	public int add(Grow grow);
	public int del(Integer id);
	public int update(Grow grow);
	public PageInfo<Grow> getByUid(Map<String,Object> params);
	public Grow getById(Integer id);
}
