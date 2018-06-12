package com.com.dome.mybatis.mock;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface MyUserMapper {

    @Select("select * from sm_user where cuserid = #{cuserid}")
    public Map queryByCuserid(String cuserid);

}
