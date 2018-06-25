package com.com.dome.mybatis.mock;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;
import java.util.Map;

public interface MyUserMapper {

    @Select("select * from users where cuserid = #{cuserid}")
    public List<Map> queryByCuserid(String cuserid);

    /**
     *  使用注解的形式进行插入
     * @param vo
     * @return
     */
    @Insert(value="insert into users (username,usercode,cuserid)         value ( #{username},#{usercode},#{cuserid} )")
    @Options(useGeneratedKeys = true, keyProperty = "pk")
//    这个是非自的主键
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
    int insertVO(UserVO vo);


}
