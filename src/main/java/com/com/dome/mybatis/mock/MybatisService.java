package com.com.dome.mybatis.mock;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public class MybatisService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyUserMapper myUserMapper;


    @Transactional
    public void query(){
        String cuserid = "cc";

        Object map = this.userMapper.selectUser(cuserid);
        System.out.println(map);

        System.out.println("处理");
        Object map1 = this.myUserMapper.queryByCuserid(cuserid);
        System.out.println(map1);





    }
}
