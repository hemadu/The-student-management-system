package cn.service.impl;

import cn.dao.PlanMapper;
import cn.entity.Plan;
import cn.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    public PlanMapper getPlanMapper() {
        return planMapper;
    }

    public void setPlanMapper(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    public int add(Plan plan) {//生成预约单
        return planMapper.insert(plan);
    }

    @Override
    public int del(Integer id) {
        return planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Plan plan) {
        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public Plan getById(Integer id) {
        return planMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Plan> getByUid(Integer uid){
        return planMapper.getByUid(uid);
    }

}
