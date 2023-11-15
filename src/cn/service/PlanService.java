package cn.service;
import cn.entity.Plan;
import java.util.List;

public interface PlanService {
	public int add(Plan plan);
	public int del(Integer id);
	public int update(Plan plan);
	public Plan getById(Integer id);
	public List<Plan> getByUid(Integer uid);
}
