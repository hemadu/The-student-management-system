package cn.service.impl;

import cn.dao.MessageMapper;
import cn.entity.Message;
import cn.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public MessageMapper getMessageMapper() {
        return messageMapper;
    }

    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public int add(Message message) {//生成预约单
        return messageMapper.insert(message);
    }

    @Override
    public int del(Integer id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public Message getById(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Message> getByUid(Map<String,Object> params){
        PageHelper.startPage((Integer)params.get("currentPageNo"),(Integer)params.get("pageSize"));
        List<Message> messageList=null;
        messageList=messageMapper.getByUid(params);
        return new PageInfo<Message>(messageList);
    }

    @Override
    public List<Message> getByMap(Map<String, Object> params) {
        return messageMapper.getByMap(params);
    }

}
