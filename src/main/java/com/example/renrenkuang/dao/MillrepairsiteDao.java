package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Millrepairsite;

import java.util.List;

public interface MillrepairsiteDao {


    List<Millrepairsite> getAllMillrepairsite(Millrepairsite millrepairsite);

    @Delete("delete from millrepairsite where id = #{id}")
    int removeMillrepairsiteById(int id);

    int addMillrepairsite(Millrepairsite millrepairsite);

    int updateMillrepairsite(Millrepairsite millrepairsite);

    @Select("select * from millrepairsite where id =#{id}")
    Millrepairsite getMillrepairsiteById(int id);

    @Select("select * from millrepairsite where millrepairsiteName =#{millrepairsiteName}")
    Millrepairsite getMillrepairsiteByMillrepairsiteName(String millrepairsiteName);




}