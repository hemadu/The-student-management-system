package cn.controller;

import cn.entity.Grade;
import cn.entity.Users;
import cn.service.GradeService;
import cn.service.UsersService;
import cn.tools.Constants;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private GradeService gradeService;

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

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request){
           Users users=usersService.login(username, password);
           if(users!=null){
               request.getSession().setAttribute(Constants.USER_SESSION,users);
               return "redirect:/jsp/index.jsp";
           }else{
               return "redirect:/jsp/login.jsp";
            }

    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/jsp/login.jsp";
    }

    @RequestMapping("mquery")
    public String mquery(String grade,String name,Integer pageIndex, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        List<Users> usersList=new ArrayList<Users>();

        if(users.getRole()==1){//老师查学生
            Map<String,Object>need=new HashMap<String,Object>();
            need.put("grade",grade);
            need.put("name",name);
            List<Grade> gradeList=gradeService.getGrade(need);
            for(Grade g:gradeList){
                Users user=null;
                if(g.getSid()!=null&&g.getSid()!=0){
                    user=usersService.getById(g.getSid());
                }
                usersList.add(user);
            }
            params.put("usersList",usersList);
        }
        PageInfo<Users> pageInfo = usersService.getAllById(params);
        request.setAttribute("pageInfo", pageInfo);
        request.getSession().setAttribute("grade", grade);
        request.getSession().setAttribute("name", name);
        return "jsp/usersList";
    }

    @RequestMapping("query")
    public String query(Integer pageIndex, HttpServletRequest request){
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        
        PageInfo<Users> pageInfo = usersService.getByMap(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/usersList";
    }

//    @RequestMapping("exist")
//    @ResponseBody//将java对象转为json格式的数据
//    public HashMap<String, String> exist(String username, HttpServletResponse response){
//        HashMap<String, String> resultMap = new HashMap<String, String>();
//        if(StringUtils.isNullOrEmpty(username)){
//            //userCode == null && userCode.equals("")
//            resultMap.put("username","error");
//        }else{
//            Users users = usersService.check(username);
//            if(null != users){
//                resultMap.put("username","exist");
//            }else{
//                resultMap.put("username", "notexist");
//            }
//        }
//        return resultMap;
//    }
//
    @RequestMapping("add")
    public String add(Users users,HttpServletRequest request){
        users.setIsdel(0);
       if(usersService.add(users)>0){
           return "jsp/login";
       }else{
           return "jsp/register";
       }
    }
//
//    @RequestMapping("addexe")
//    public String addexe(Users users,HttpServletRequest request){
//        users.setIsdel(0);
//        if(usersService.add(users)>0){
//            return "redirect:/users/query";
//        }else{
//            return "jsp/usersadd";
//        }
//    }
////    @RequestMapping("del")
////    public String del(Integer id){
////        if(usersService.del(id)>0){
////            return "redirect:/users/query";
////        }
////        return "redirect:/users/query";
////    }
    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
            if(usersService.del(id)>0){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        return resultMap;
    }
//
//    @RequestMapping("mupdate")
//    public String mupdate(Integer id,HttpServletRequest request){
//        Users users=usersService.getById(id);
//        Calendar calendar = Calendar.getInstance();
//        Date now=new Date();
//        List<Date> dateList=new ArrayList<Date>();
//        for(int i=1;i<=7;i++){
//            calendar.setTime(now);
//            calendar.add(calendar.DAY_OF_MONTH,+i);
//            dateList.add(calendar.getTime());
//        }
//        request.setAttribute("users",users);
//        request.setAttribute("dateList",dateList);
//        return "jsp/users";
//    }
//
    @RequestMapping("update")
    public String update(HttpServletRequest request){
//        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
//        request.getSession().setAttribute(Constants.USER_SESSION,users);
        return "jsp/userModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Users users,HttpServletRequest request){

    if(usersService.update(users)>0){
        request.getSession().setAttribute(Constants.USER_SESSION,users);
        return "jsp/index";
    }else{
        return "jsp/userModify";
    }
    }

    @RequestMapping("updateList")
    public String updateList(Integer id,HttpServletRequest request){
        Users users=usersService.getById(id);
        request.setAttribute("users",users);
        return "jsp/userUpdate";
    }
    @RequestMapping("updateListexe")
    public String updateListexe(Users users){
            if(usersService.update(users)>0){
                return "redirect:/users/query";
            }
        return "jsp/userUpdate";
    }


    @RequestMapping("updatepwd")
    public String updatepwd(String password,HttpServletRequest request){
        if(!StringUtils.isNullOrEmpty(password)){
            Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
            users.setPassword(password);
            if(usersService.update(users)>0){
                return "redirect:/users/logout";
            }
        }
        return "jsp/userModify";
    }
//
//    @RequestMapping("pwdupdate")
//    @ResponseBody//将java对象转为json格式的数据
//    public Map<String, String> pwdupdate(String oldpassword, HttpServletRequest request,HttpServletResponse response){
//            Object o = request.getSession().getAttribute(Constants.USER_SESSION);
//            Map<String, String> resultMap = new HashMap<String, String>();
//            if(null == o ){//session过期
//                resultMap.put("result", "sessionerror");
//            }else if(StringUtils.isNullOrEmpty(oldpassword)){//旧密码输入为空
//                resultMap.put("result", "error");
//            }else{
//                String sessionPwd = ((Users)o).getPassword();
//                if(oldpassword.equals(sessionPwd)){
//                    resultMap.put("result", "true");
//                }else{//旧密码输入不正确
//                    resultMap.put("result", "false");
//                }
//            }
//            return resultMap;
//    }

    @RequestMapping("pwdsave")
    public String pwdsave(String newpassword, HttpServletRequest request){
        Object o = request.getSession().getAttribute(Constants.USER_SESSION);
        int flag = 0;
        if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
            Users users=((Users)o);
            users.setPassword(newpassword);
            flag = usersService.update(users);
            if(flag>0){
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
                //removeAttribute(Constants.USER_SESSION);//session注销
            }else{
                request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
            }
        }else{
            request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
        }
        return "jsp/pwdupdate";
    }
}
