package cn.controller;

import cn.entity.Comment;
import cn.entity.Grade;
import cn.entity.Users;
import cn.service.CommentService;
import cn.service.GradeService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private GradeService gradeService;

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

//    @RequestMapping("mquery")
//    public String mquery(String title,Integer type,Integer pageIndex, HttpServletRequest request){
//        //设置页面容量
//        int pageSize = Constants.pageSize;
//        if(pageIndex == null){
//            pageIndex=1;
//        }
//        Map<String,Object>params=new HashMap<String,Object>();
//        params.put("currentPageNo",pageIndex);
//        params.put("pageSize",pageSize);
//        if(!StringUtils.isNullOrEmpty(title)){
//            params.put("title",title);
//            request.setAttribute("title", title);
//        }
//        if(type!=null){
//            params.put("type",type);
//            request.setAttribute("type", type);
//        }
//        PageInfo<Comment> pageInfo = commentService.getByMap(params);
//        request.setAttribute("pageInfo", pageInfo);
//        return "jsp/comment";
//    }

    @RequestMapping("query")
    public String query(Integer pageIndex, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        params.put("tid",users.getId());

        PageInfo<Comment> pageInfo = commentService.getByTid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/commentList";
    }

    @RequestMapping("add")
    public String add(Comment comment,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        List<Grade> gradeList=gradeService.getAllStu(users.getId());
        Boolean isAdd=true;
        for(Grade g:gradeList){
            Comment temp=new Comment();
            temp.setTid(users.getId());
            temp.setSid(g.getSid());
            temp.setContent(comment.getContent());
            if(!(commentService.add(temp)>0)){
                isAdd=false;
            }
        }
        if(isAdd){
            return "redirect:/comment/query";
        }else{
            return "jsp/comment";
        }
    }
    //    @RequestMapping("del")
//    public String del(Integer id){
//        if(commentService.del(id)>0){
//            return "redirect:/comment/query";
//        }
//        return "redirect:/comment/query";
//    }
    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> deluser(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(commentService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

//    @RequestMapping("mupdate")
//    public String mupdate(Integer id,HttpServletRequest request){
//        Comment comment=commentService.getById(id);
//        request.setAttribute("comment",comment);
//        return "jsp/commentdetail";
//    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Comment comment=commentService.getById(id);
        request.setAttribute("comment",comment);
        return "jsp/commentModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Comment comment){
        if(commentService.update(comment)>0){
            return "redirect:/comment/update?id="+comment.getId();
        }else{
            return "jsp/commentModify";
        }
    }
}
