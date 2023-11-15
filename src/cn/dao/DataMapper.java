package cn.dao;

import cn.entity.Data;
import cn.entity.Grow;

import java.util.List;
import java.util.Map;

public interface DataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);

    List<Data> getByUid(Map<String,Object> params);

    List<Data> getByMap(Map<String,Object> params);
}