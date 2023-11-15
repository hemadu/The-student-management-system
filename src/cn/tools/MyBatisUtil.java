package cn.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    static{
        try {
            //1、加载核心配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2、产生一个SqlSessionFactory
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession
    public static SqlSession getSqlSession(){
        //取
        sqlSession=(SqlSession)threadLocal.get();
        if(sqlSession==null){
            //true自动提交
            sqlSession=sqlSessionFactory.openSession(true);
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    //关闭
    public static void closeSession(){
        threadLocal.set(null);
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
