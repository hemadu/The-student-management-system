package cn.dao;

import cn.entity.Grade;
import cn.entity.Users;

import java.util.List;
import java.util.Map;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> getTea(Integer tid);//得到老师的班级

    List<Grade> getGrade(Map<String,Object> params);//得到某班级列

    Grade getStu(Integer sid);//得到学生的班级

    List<Grade> getAllStu(Integer tid);//得到老师的所有学生

    List<Grade> getAllTea(Integer sid);//得到学生的所有老师
}