package cn.controller;

import cn.entity.Grow;
import cn.entity.Message;
import cn.entity.Users;
import cn.service.GrowService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grow")
public class GrowController {
    @Autowired
    private GrowService growService;

    public GrowService getGrowService() {
        return growService;
    }

    public void setGrowService(GrowService growService) {
        this.growService = growService;
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

        PageInfo<Grow> pageInfo = growService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/growList";
    }

    @RequestMapping("add")
    public String add(Grow grow,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        grow.setUid(users.getId());
        if(growService.add(grow)>0){
            return "redirect:/grow/query";
        }else{
            return "jsp/growAdd";
        }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(growService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Grow grow=growService.getById(id);
        request.setAttribute("grow",grow);
        return "jsp/growModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Grow grow){
        if(growService.update(grow)>0){
            return "redirect:/grow/query";
        }else{
            return "jsp/growModify";
        }
    }
}
