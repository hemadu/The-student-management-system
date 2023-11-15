package cn.dao;

import cn.entity.Account;
import cn.entity.Data;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Data> getByUid(Map<String,Object> params);
}