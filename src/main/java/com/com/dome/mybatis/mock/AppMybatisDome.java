package com.com.dome.mybatis.mock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppMybatisDome {

    static String resource = "mybatis.xml";

    public static void main(String[] args) throws Exception {
//        doMybatisByMapperXML();
        doMybatisByMapperJava();
//        doMybatisBySpring();


    }

    /**
     *  说明：基于注解的动态sql较为难开发，建议使用配置文件设置
     *  在spring 开发下，mapper接口必须有并且与 配置文件同名
     * @throws IOException
     */
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

        UserMapper mapper1 = session.getMapper(UserMapper.class);

        UserVO vo = new UserVO();
        vo.setCuserid("cc");
        vo.setUsercode("ccCdoe");
        vo.setUsername("张三");
//        int userinsert = mapper1.userinsert(vo);
//        System.out.println(userinsert);
        System.out.println(vo);
        List<RoleVO> list  = new ArrayList<>();
        RoleVO rvo = null;
        for (int i =0;i<4;i++){
            rvo = new RoleVO();
            rvo.setRolename("role姓名"+i);
            rvo.setUserid(vo.getPk());
            list.add(rvo);
//                    mapper1.insertRole(rvo);
        }

//        Object o1 = mapper1.insertBatchRole(list);
//        System.out.println(o1);
        for (RoleVO roleVO: list             ) {
            System.out.println(roleVO);
        }

        List<UserVO> userVOS = mapper1.selectUserAndRole(53);
        System.out.println(userVOS);


        vo = new UserVO();
        vo.setCuserid("cc2");
        vo.setUsercode("ccCdoe2");
        vo.setUsername("张三2");
        Object o = mapper.insertVO(vo);
        System.out.println(o);
        System.out.println(vo);


        Object dd = mapper.queryByCuserid("cc");

        System.out.println(dd);


        dd = mapper1.selectUser("cc");
        System.out.println(dd);

        session.commit();
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
