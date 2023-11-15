package cn.controller;

import cn.entity.Message;
import cn.entity.Grade;
import cn.entity.Users;
import cn.service.MessageService;
import cn.service.GradeService;
import cn.tools.Constants;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private GradeService gradeService;

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
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
//        PageInfo<Message> pageInfo = messageService.getByMap(params);
//        request.setAttribute("pageInfo", pageInfo);
//        return "jsp/message";
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
        params.put("uid",users.getId());

        PageInfo<Message> pageInfo = messageService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/messageList";
    }

    @RequestMapping("add")
    public String add(Message message,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Integer id = (Integer) request.getSession().getAttribute("id");
        Boolean change = (Boolean) request.getSession().getAttribute("change");
        Message temp=new Message();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        temp.setLid(users.getId());
        temp.setUid(id);
        temp.setContent(message.getContent());
        temp.setTime(sdf.format(date));
        if(messageService.add(temp)>0){
            if(change){
                return "redirect:/message/mupdate?id="+id;
            }else{
                return "redirect:/message/update?id="+id;
            }

        }else{
            return "jsp/messageList";
        }
    }

    @RequestMapping("madd")
    public String madd(Message message,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Message temp=new Message();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        temp.setLid(users.getId());
        temp.setUid(1);
        temp.setContent(message.getContent());
        temp.setTime(sdf.format(date));
        if(messageService.add(temp)>0){
            return "jsp/index";
        }else{
            return "jsp/contact";
        }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> deluser(@PathVariable("id") Integer id, HttpServletResponse response){

        Message message=messageService.getById(id);
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("uid",message.getUid());
        params.put("lid",message.getLid());
        List<Message> messageList=messageService.getByMap(params);
        Boolean isDel=true;
        for(Message m:messageList){
            if(!(messageService.del(m.getId())>0)){
                isDel=false;
            }
        }

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(messageService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

//    @RequestMapping("mupdate")
//    public String mupdate(Integer id,HttpServletRequest request){
//        Message message=messageService.getById(id);
//        request.setAttribute("message",message);
//        return "jsp/messagedetail";
//    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("uid",users.getId());
        params.put("lid",id);
        List<Message> messageList=messageService.getByMap(params);
        request.setAttribute("messageList",messageList);
        request.getSession().setAttribute("id",id);
        Boolean change=false;
        request.getSession().setAttribute("change",change);
        return "jsp/messageAdd";
    }

    @RequestMapping("mupdate")
    public String mupdate(Integer id,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Map<String,Object>params=new HashMap<String,Object>();
        params.put("uid",id);
        params.put("lid",users.getId());
        List<Message> messageList=messageService.getByMap(params);
        request.setAttribute("messageList",messageList);
        request.getSession().setAttribute("id",id);
        Boolean change=true;
        request.getSession().setAttribute("change",change);
        return "jsp/messageAdd";
    }

}
