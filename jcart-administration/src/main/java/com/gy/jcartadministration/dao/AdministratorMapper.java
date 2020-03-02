package com.gy.jcartadministration.dao;

import com.github.pagehelper.Page;
import com.gy.jcartadministration.po.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUsername(@Param("username") String username);

    Page<Administrator> selectList();
}