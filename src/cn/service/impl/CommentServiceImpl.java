package cn.service.impl;

import cn.dao.CommentMapper;
import cn.entity.Comment;
import cn.entity.Users;
import cn.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public int add(Comment comment) {//生成预约单
        return commentMapper.insert(comment);
    }

    @Override
    public int del(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public Comment getById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Comment getBySid(Integer sid) {
        return commentMapper.getBySid(sid);
    }

    @Override
    public PageInfo<Comment> getByTid(Map<String,Object> params){
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Comment> commentList=null;
        commentList=commentMapper.getByTid(params);
        return new PageInfo<Comment>(commentList);
    }

}
