package com.com.dome.mybatis.mock;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {


    public Map selectUser(String cuserid);

}
