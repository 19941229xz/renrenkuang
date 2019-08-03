package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Mine;

import java.util.List;

public interface MineDao {


    List<Mine> getAllMine(Mine mine);

    @Delete("delete from mine where id = #{id}")
    int removeMineById(int id);

    int addMine(Mine mine);

    int updateMine(Mine mine);

    @Select("select * from mine where id =#{id}")
    Mine getMineById(int id);

    @Select("select * from mine where mineName =#{mineName}")
    Mine getMineByMineName(String mineName);




}