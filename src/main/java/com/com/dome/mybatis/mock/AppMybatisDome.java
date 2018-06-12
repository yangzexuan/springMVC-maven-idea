package com.com.dome.mybatis.mock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class AppMybatisDome {

    static String resource = "mybatis.xml";

    public static void main(String[] args) throws Exception {
//        doMybatisByMapperXML();
//        doMybatisByMapperJava();
        doMybatisBySpring();


    }

    private static void doMybatisByMapperJava() throws IOException {
        System.out.println("使用mapper接口的代理对象查询");
//        1、读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        创建连接工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        创建session连接
        SqlSession session = sqlSessionFactory.openSession();

//        获取mapper的代理对象
//        使用代理对象进行SQL操作。

        //  使用接口
        MyUserMapper mapper = session.getMapper(MyUserMapper.class);

        Map dd = mapper.queryByCuserid("dd");

        System.out.println(dd);

        UserMapper mapper1 = session.getMapper(UserMapper.class);
        dd = mapper1.selectUser("cc");

        System.out.println(dd);


//4. 关闭 Session
        session.close();

    }
    /**
     * @auther yangzxa
     *  创建于 2018年6月11日15:05:33
     *  <br/> 使用配置文件启用mybatis
     */
    private static void doMybatisByMapperXML() throws IOException {
//        String resource = "mybatis.xml";
        System.out.println("使用mapper配置文件查询");

        InputStream inputStream = Resources.getResourceAsStream(resource);
//1. 创建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//2. 获取 Session 对象
        SqlSession session = sqlSessionFactory.openSession();

//3. 执行查询
//        执行mapper.xml中的配置文件
        Map customer =
                session.selectOne("com.com.dome.mybatis.mock.UserMapper.selectUser", "cc");
        System.out.println(customer);

//4. 关闭 Session
        session.close();

    }

    private static String springpath = "applicationContext-mybatis.xml";
    private static void doMybatisBySpring() throws Exception{
        System.out.println("使用spring 配置文件查询");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springpath);

        MybatisService bean = context.getBean(MybatisService.class);

        bean.query();



    }
}
