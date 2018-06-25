package com.com.dome.mybatis.mock;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    public List<Map> selectUser(String cuserid);

    int userinsert(UserVO vo);

    int insertBatchRole(List<RoleVO> list);

    int insertRole(RoleVO vo);

    List<UserVO> selectUserAndRole (int pk);

}
