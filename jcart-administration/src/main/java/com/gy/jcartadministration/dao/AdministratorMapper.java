package com.gy.jcartadministration.dao;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.po.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator administrator);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUsername(@Param("username") String username);

    Page<Administrator> selectList();

    int batchDelete(@Param("administratorIds") List<Integer> administratorIds);

    Administrator selectByEmail(@Param("email") String email);
}