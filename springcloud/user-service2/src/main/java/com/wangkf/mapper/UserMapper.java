package com.wangkf.mapper;

import com.wangkf.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 基于接口编程，通过mybatis与spring整合注入，在xml中编写sql语句
 */
@Mapper
public interface UserMapper  {

    User selectByPrimaryKey(String username);

}
