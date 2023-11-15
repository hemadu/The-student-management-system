package cn.dao;
import cn.entity.Comment;
import cn.entity.Message;
import java.util.List;
import java.util.Map;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> getByMap(Map<String,Object> params);

    List<Message> getByUid(Map<String,Object> params);
}