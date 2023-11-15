package cn.dao;

import cn.entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users check(String username);

    List<Users> selectAll(Map<String,Object> params);

    int delete(Integer id);
}