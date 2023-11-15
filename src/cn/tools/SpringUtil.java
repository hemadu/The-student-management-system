package cn.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
    static ApplicationContext ctx;
    static{
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
   public static Object getBean(String beanName){
        return ctx.getBean(beanName);
    }
}
