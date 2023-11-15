package cn.service.impl;

import cn.dao.GradeMapper;
import cn.entity.Grade;
import cn.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    public GradeMapper getGradeMapper() {
        return gradeMapper;
    }

    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    @Override
    public int add(Grade grade) {
        return gradeMapper.insert(grade);
    }

    @Override
    public int del(Integer id) {
        return gradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Grade grade) {
        return gradeMapper.updateByPrimaryKeySelective(grade);
    }

    @Override
    public Grade getById(Integer id) {
        return gradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Grade> getTea(Integer tid) {
        return gradeMapper.getTea(tid);
    }

    @Override
    public List<Grade> getGrade(Map<String, Object> params) {
        return gradeMapper.getGrade(params);
    }

    @Override
    public Grade getStu(Integer sid) {
        return gradeMapper.getStu(sid);
    }

    @Override
    public List<Grade> getAllStu(Integer tid) {
        return gradeMapper.getAllStu(tid);
    }

    @Override
    public List<Grade> getAllTea(Integer sid) {
        return gradeMapper.getAllTea(sid);
    }

}
