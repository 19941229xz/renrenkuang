package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Mill;

import java.util.List;

public interface MillDao {


    List<Mill> getAllMill(Mill mill);

    @Delete("delete from mill where id = #{id}")
    int removeMillById(int id);

    int addMill(Mill mill);

    int updateMill(Mill mill);

    @Select("select * from mill where id =#{id}")
    Mill getMillById(int id);

    @Select("select * from mill where millName =#{millName}")
    Mill getMillByMillName(String millName);




}