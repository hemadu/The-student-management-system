package cn.controller;

import cn.entity.Account;
import cn.entity.Users;
import cn.service.AccountService;
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
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
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

        PageInfo<Account> pageInfo = accountService.getByUid(params);
        request.setAttribute("pageInfo", pageInfo);
        return "jsp/accountList";
    }

    @RequestMapping("add")
    public String add(Account account,HttpServletRequest request){
        Users users = (Users) request.getSession().getAttribute(Constants.USER_SESSION);
        account.setUid(users.getId());
        if(accountService.add(account)>0){
            return "redirect:/account/query";
        }else{
            return "jsp/accountAdd";
        }
    }

    @RequestMapping("del/{id}")
    @ResponseBody//将java对象转为json格式的数据
    public HashMap<String, String> del(@PathVariable("id") Integer id, HttpServletResponse response){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(accountService.del(id)>0){
            resultMap.put("delResult", "true");
        }else{
            resultMap.put("delResult", "false");
        }
        return resultMap;
    }

    @RequestMapping("update")
    public String update(Integer id,HttpServletRequest request){
        Account account=accountService.getById(id);
        request.setAttribute("account",account);
        return "jsp/accountModify";
    }

    @RequestMapping("updateexe")
    public String updateexe(Account account){
        if(accountService.update(account)>0){
            return "redirect:/account/query";
        }else{
            return "jsp/accountModify";
        }
    }
}
