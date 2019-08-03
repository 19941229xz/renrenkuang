package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.DigCoin;

import java.util.List;

public interface DigCoinDao {


    List<DigCoin> getAllDigCoin(DigCoin digCoin);

    @Delete("delete from digCoin where id = #{id}")
    int removeDigCoinById(int id);

    int addDigCoin(DigCoin digCoin);

    int updateDigCoin(DigCoin digCoin);

    @Select("select * from digCoin where id =#{id}")
    DigCoin getDigCoinById(int id);

    @Select("select * from digCoin where digCoinName =#{digCoinName}")
    DigCoin getDigCoinByDigCoinName(String digCoinName);




}