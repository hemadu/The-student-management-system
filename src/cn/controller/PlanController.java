package cn.controller;

import cn.entity.Comment;
import cn.entity.Plan;
import cn.entity.Users;
import cn.service.GradeService;
import cn.service.PlanService;
import cn.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    public PlanService getPlanService() {
        return planService;
    }

    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    @RequestMapping("query")
    public String query(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        List<Plan> pageInfo = planService.getByUid(users.getId());
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/planList";
    }

    @RequestMapping("add")
    public String add(Plan plan,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        plan.setUid(users.getId());
        if(planService.add(plan)>0){
            return "redirect:/plan/query";
        }else{
            return "jsp/planAdd";
        }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(planService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Plan plan=planService.getById(id);
        request.setAttribute("plan",plan);
        return "jsp/planModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Plan plan){
        if(planService.update(plan)>0){
            return "redirect:/plan/query";
        }else{
            return "jsp/planModify";
        }
    }
}
