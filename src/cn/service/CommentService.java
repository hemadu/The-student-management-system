package cn.service;


import cn.entity.Comment;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface CommentService {
	public int add(Comment no);
	public int del(Integer id);
	public int update(Comment no);
	public Comment getById(Integer id);
	public PageInfo<Comment> getByTid(Map<String,Object> params);
	public Comment getBySid(Integer sid);
}
