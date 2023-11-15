package cn.tools;

import cn.entity.Data;
import cn.service.DataService;
import cn.service.GradeService;
import cn.service.DataService;
import com.github.pagehelper.PageInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SpringTest {
    public static void main(String[] args){
        //加载配置文件
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataService dataService=(DataService) SpringUtil.getBean("dataServiceImpl");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date();
        System.out.println(sdf.format(date.getTime()));
//        Map<String,Object> params=new HashMap<String,Object>();
//        params.put("currentPageNo",1);
//        params.put("pageSize",5);
//        params.put("tid",1);
//        PageInfo<Data> pageInfo = dataService.getByTid(params);
//        System.out.println(pageInfo);
          System.out.println(dataService.getById(1));




        //add
        // System.out.println(doctorService.add(new Doctor(null,null,"d222","222",2,0,28,"男","陈秋实",30,"15022222222",0)));//userService.getUserCount(null,null)
        //del
        //System.out.println(doctorService.del(2));
        //从容器里面获取对象
        //update
        //System.out.println(doctorService.update(new Doctor(3,"11","d222","222",2,0,28,"男","陈秋实",30,"15022222222",0)));
        //getById




//        Map<String,Object> map=new HashMap<String, Object>();
//        String state="0";
//        String pid="1";
//        map.put("state",state);
//        map.put("pid",pid);
//        map.put("currentPageNo",1);
//        map.put("pageSize",1);
//
//        PageInfo<No> pageInfo = noService.getByMap(map);
//        for(int i=0;i<pageInfo.getSize();i++){
//            System.out.println(pageInfo);
//        }

        //login
        //System.out.println(doctorService.login("d111","112"));
        //check
        //System.out.println(doctorService.check("d111"));


//        Hello hello=(Hello)ctx.getBean("hello");
//        hello.print();
//        Printer printer=(Printer)ctx.getBean("printer");
//        printer.print();
//        BookService bookService=(BookService)ctx.getBean("bookService");
//        bookService.buy("西游记",50,10);
    }

}
