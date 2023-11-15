package cn.service;



import cn.entity.Grade;
import cn.entity.Users;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface GradeService {
	public int add(Grade grade);
	public int del(Integer id);
	public int update(Grade grade);
	public Grade getById(Integer id);

	public List<Grade> getTea(Integer tid);//得到老师的班级

	public List<Grade> getGrade(Map<String,Object> params);//得到某班级列

	public Grade getStu(Integer sid);//得到学生的班级

	public List<Grade> getAllStu(Integer tid);//得到老师的所有学生

	public List<Grade> getAllTea(Integer sid);//得到学生的所有老师
}
