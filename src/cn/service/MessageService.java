package cn.service;

import cn.entity.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MessageService {
	public int add(Message message);
	public int del(Integer id);
	public int update(Message message);
	public Message getById(Integer id);
	public PageInfo<Message> getByUid(Map<String,Object> params);
	public List<Message> getByMap(Map<String,Object> params);
}
