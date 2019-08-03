package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Coin;

import java.util.List;

public interface CoinDao {


    List<Coin> getAllCoin(Coin coin);

    @Delete("delete from coin where id = #{id}")
    int removeCoinById(int id);

    int addCoin(Coin coin);

    int updateCoin(Coin coin);

    @Select("select * from coin where id =#{id}")
    Coin getCoinById(int id);

    @Select("select * from coin where coinName =#{coinName}")
    Coin getCoinByCoinName(String coinName);




}