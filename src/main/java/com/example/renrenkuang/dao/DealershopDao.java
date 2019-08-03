package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Dealershop;

import java.util.List;

public interface DealershopDao {


    List<Dealershop> getAllDealershop(Dealershop dealershop);

    @Delete("delete from dealershop where id = #{id}")
    int removeDealershopById(int id);

    int addDealershop(Dealershop dealershop);

    int updateDealershop(Dealershop dealershop);

    @Select("select * from dealershop where id =#{id}")
    Dealershop getDealershopById(int id);

    @Select("select * from dealershop where dealershopName =#{dealershopName}")
    Dealershop getDealershopByDealershopName(String dealershopName);




}