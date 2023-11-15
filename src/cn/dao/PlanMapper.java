package cn.dao;

import cn.entity.Friends;
import cn.entity.Plan;

import java.util.List;
import java.util.Map;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    List<Plan> getByUid(Integer uid);
}