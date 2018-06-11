package com.com.dome.mybatis.mock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class AppMybatisDome {

    public static void main(String[] args) throws IOException {
        doMybatisByXML();

    }

    /**
     * @auther yangzxa
     *  创建于 2018年6月11日15:05:33
     *  <br/> 使用配置文件启用mybatis
     */
    private static void doMybatisByXML() throws IOException {
        String resource = "mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
//1. 创建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//2. 获取 Session 对象
        SqlSession session = sqlSessionFactory.openSession();

//3. 执行查询
        Map customer =
                session.selectOne("com.com.dome.mybatis.mock.UserMapper.selectUser", "cc");
        System.out.println(customer);

//4. 关闭 Session
        session.close();

    }
}
