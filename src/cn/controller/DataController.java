package cn.controller;

import cn.entity.Data;
import cn.entity.Users;
import cn.service.DataService;
import cn.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("query")
    public String query(Integer pageIndex, HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        //设置页面容量
        int pageSize = Constants.pageSize;
        if(pageIndex == null){
            pageIndex=1;
        }
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("currentPageNo",pageIndex);
        params.put("pageSize",pageSize);
        params.put("uid",users.getId());

        PageInfo<Data> pageInfo = dataService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/dataList";
    }

    @RequestMapping("add")
    public String add(Data data,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        data.setUid(users.getId());
        if(dataService.add(data)>0){
            return "redirect:/data/query";
        }else{
            return "jsp/dataAdd";
        }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(dataService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Data data=dataService.getById(id);
        request.setAttribute("data",data);
        return "jsp/dataModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Data data){
        if(dataService.update(data)>0){
            return "redirect:/data/query";
        }else{
            return "jsp/dataModify";
        }
    }

    @RequestMapping("getPk")
    public String getPk(Integer id,HttpServletRequest request){
        request.getSession().setAttribute("fid",id);
        return "jsp/dataPk";
    }

    @RequestMapping("pk/{type}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> pk(@PathVariable("type") Integer type, HttpServletRequest request){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        Integer fid = (Integer) request.getSession().getAttribute("fid");
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("uid",users.getId());
        params.put("fid",fid);
        params.put("type",type);//
        Integer temp=dataService.pk(params);
        if(temp==0){
            resultMap.put("Result", "true");
        }else if(temp==1){
            resultMap.put("Result", "false");
        }else{
            resultMap.put("Result", "equal");
        }
        return resultMap;
    }
}
