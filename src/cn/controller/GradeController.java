package cn.controller;

import cn.entity.Grade;
import cn.entity.Users;
import cn.service.GradeService;
import cn.service.UsersService;
import cn.tools.Constants;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private UsersService usersService;

    public UsersService getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping("query")
    public String query(HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        List<Grade> gradeList = gradeService.getTea(users.getId());
        request.setAttribute("gradeList", gradeList);
        return "jsp/gradeList";
    }

    @RequestMapping("addStuexe")
    public String addStuexe(Integer id,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        String grade = (String) request.getSession().getAttribute("grade");
        String name = (String) request.getSession().getAttribute("name");
        if(usersService.getById(id).getRole()==1){
            return "jsp/gradeStuAdd";
        }else{
        Grade temp=new Grade();
        temp.setTid(users.getId());
        temp.setGrade(grade);
        temp.setName(name);
        temp.setSid(id);
        if(gradeService.add(temp)>0){
            return "redirect:/grade/query";
        }else{
            return "jsp/gradeStuAdd";
        }
        }
    }

    @RequestMapping("addStu")
    public String addStu(Integer id,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Grade temp=new Grade();
        gradeService.getTea(users.getId());
        request.getSession().setAttribute("grade",temp.getGrade());
        request.getSession().setAttribute("name",temp.getName());
        return "jsp/gradeStuAdd";
    }

    @RequestMapping("add")
    public String add(Grade grade,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        grade.setTid(users.getId());
        if(gradeService.add(grade)>0){
            return "redirect:/grade/query";
        }else{
            return "jsp/gradeAdd";
        }
    }
    //    @RequestMapping("del")
//    public String del(Integer id){
//        if(gradeService.del(id)>0){
//            return "redirect:/grade/query";
//        }
//        return "redirect:/grade/query";
//    }

    @RequestMapping("delStu/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> delStu(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(gradeService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        Grade grade=gradeService.getById(id);
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("name",grade.getName());
        params.put("grade",grade.getGrade());
        List<Grade> gradeList=gradeService.getGrade(params);
        Boolean isDel=true;
        for(Grade g:gradeList){
            if(!(gradeService.del(g.getId())>0)){
                isDel=false;
            }
        }

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(isDel){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Grade grade=gradeService.getById(id);
        request.setAttribute("grade",grade);
        return "jsp/gradeModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Grade grade){
        Grade temp1=gradeService.getById(grade.getId());
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("name",temp1.getName());
        params.put("grade",temp1.getGrade());
        List<Grade> gradeList=gradeService.getGrade(params);
        Boolean isUpdate=true;
        Grade temp2=new Grade();
        temp2.setName(grade.getName());
        temp2.setGrade(grade.getGrade());
        for(Grade g:gradeList){
            temp2.setId(g.getId());
            if(!(gradeService.update(temp2)>0)){
                isUpdate=false;
            }
        }

        if(isUpdate){
            return "redirect:/grade/query";
        }else{
            return "jsp/gradeModify";
        }
        }
}
