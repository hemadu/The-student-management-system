package cn.controller;

import cn.entity.Grade;
import cn.entity.Friends;
import cn.entity.Users;
import cn.service.GradeService;
import cn.service.FriendsService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    private FriendsService friendsService;

    @Autowired
    private GradeService gradeService;

    public FriendsService getFriendsService() {
        return friendsService;
    }

    public void setFriendsService(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

//    @RequestMapping("mquery")
//    public String mquery(String grade,String name,Integer pageIndex, HttpServletRequest request){
//        Friends friends = (Friends) request.getSession().getAttribute(Constants.USER_SESSION);
//        //设置页面容量
//        int pageSize = Constants.pageSize;
//        if(pageIndex == null){
//            pageIndex=1;
//        }
//        Map<String,Object>params=new HashMap<String,Object>();
//        params.put("currentPageNo",pageIndex);
//        params.put("pageSize",pageSize);
//        List<Friends> friendsList=new ArrayList<Friends>();
//
//        if(friends.getRole()==1){//老师查学生
//            Map<String,Object>need=new HashMap<String,Object>();
//            need.put("grade",grade);
//            need.put("name",name);
//            List<Grade> gradeList=gradeService.getGrade(need);
//            for(Grade g:gradeList){
//                Friends user=friendsService.getById(g.getSid());
//                friendsList.add(user);
//            }
//            params.put("friendsList",friendsList);
//        }else{//学生搜
//
//        }
//        PageInfo<Friends> pageInfo = friendsService.getAllById(params);
//        request.setAttribute("pageInfo", pageInfo);
//        request.getSession().setAttribute("grade", grade);
//        request.getSession().setAttribute("name", name);
//        return "jsp/friendsList";
//    }

    @RequestMapping("query")
    public String query(Integer fid,Integer pageIndex, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        params.put("uid",users.getId());
        params.put("fid",fid);
        
        PageInfo<Friends> pageInfo = friendsService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("fid", fid);
        return "jsp/friendsList";
    }

    @RequestMapping("add")
    public String add(Friends friends,HttpServletRequest request){
        if(friends.getFid()==1){
            return "jsp/friendsAdd";
        }
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        friends.setUid(users.getId());
       if(friendsService.add(friends)>0){
           return "redirect:/friends/query";
       }else{
           return "jsp/friendsAdd";
       }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
            if(friendsService.del(id)>0){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
//        Friends friends = (Friends) request.getSession().getAttribute(Constants.USER_SESSION);
//        request.getSession().setAttribute(Constants.USER_SESSION,friends);
        return "jsp/userModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Friends friends,HttpServletRequest request){

    if(friendsService.update(friends)>0){
        request.getSession().setAttribute(Constants.USER_SESSION,friends);
        return "jsp/index";
    }else{
        return "jsp/userModify";
    }
    }
}
