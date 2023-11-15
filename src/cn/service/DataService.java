package cn.service;


import cn.entity.Data;
import cn.entity.Data;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DataService {
	public int add(Data data);
	public int del(Integer id);
	public int update(Data data);
	public PageInfo<Data> getByUid(Map<String,Object> params);
	public Integer pk(Map<String,Object> params);
	public Data getById(Integer id);
}
