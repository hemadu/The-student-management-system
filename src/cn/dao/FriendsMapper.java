package cn.dao;

import cn.entity.Friends;
import cn.entity.Users;

import java.util.List;
import java.util.Map;

public interface FriendsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);

    List<Friends> getByUid(Map<String,Object> params);
}