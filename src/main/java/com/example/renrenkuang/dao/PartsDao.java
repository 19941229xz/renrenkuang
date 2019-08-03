package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Parts;

import java.util.List;

public interface PartsDao {


    List<Parts> getAllParts(Parts parts);

    @Delete("delete from parts where id = #{id}")
    int removePartsById(int id);

    int addParts(Parts parts);

    int updateParts(Parts parts);

    @Select("select * from parts where id =#{id}")
    Parts getPartsById(int id);

    @Select("select * from parts where partsName =#{partsName}")
    Parts getPartsByPartsName(String partsName);




}