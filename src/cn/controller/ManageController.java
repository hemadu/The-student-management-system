package cn.controller;

import cn.entity.*;
import cn.service.*;
import cn.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private PlanService planService;

    @Autowired
    private GrowService growService;

    @Autowired
    private DataService dataService;

    public UsersService getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public PlanService getPlanService() {
        return planService;
    }

    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    public GrowService getGrowService() {
        return growService;
    }

    public void setGrowService(GrowService growService) {
        this.growService = growService;
    }

    public DataService getDataService() {
        return dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("query")
    public String query(Integer id, HttpServletRequest request){
        request.getSession().setAttribute("id",id);
        return "jsp/manage";
    }

    @RequestMapping("planQuery")
    public String planQuery(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        if(users.getRole()==1){//只有老师可以访问
            Integer id = (Integer) request.getSession().getAttribute("id");
            List<Plan> pageInfo = planService.getByUid(id);
            request.setAttribute("pageInfo", pageInfo);
            return "jsp/mplanList";
        }else{
            return "jsp/index";
        }

    }

    @RequestMapping("planUpdate")
    public String planUpdate(Integer id,HttpServletRequest request){
            Plan plan=planService.getById(id);
            request.setAttribute("plan",plan);
            return "jsp/mplanModify";
        }

    @RequestMapping("growQuery")
    public String growQuery(Integer pageIndex, HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("id");
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        params.put("uid",id);
        params.put("role",0);
        PageInfo<Grow> pageInfo = growService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/mgrowList";
    }

    @RequestMapping("growUpdate")
    public String growUpdate(Integer id,HttpServletRequest request){
        Grow grow=growService.getById(id);
        request.setAttribute("grow",grow);
        return "jsp/mgrowModify";
    }

    @RequestMapping("dataQuery")
    public String dataQuery(Integer pageIndex,HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("id");
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        params.put("uid",id);
        params.put("role",0);
        PageInfo<Data> pageInfo = dataService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/mdataList";
    }

    @RequestMapping("dataUpdate")
    public String dataUpdate(Integer id,HttpServletRequest request){
        Data data=dataService.getById(id);
        request.setAttribute("data",data);
        return "jsp/mdataModify";
    }
}
