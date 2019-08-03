package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Industrytrends;

import java.util.List;

public interface IndustrytrendsDao {


    List<Industrytrends> getAllIndustrytrends(Industrytrends industrytrends);

    @Delete("delete from industrytrends where id = #{id}")
    int removeIndustrytrendsById(int id);

    int addIndustrytrends(Industrytrends industrytrends);

    int updateIndustrytrends(Industrytrends industrytrends);

    @Select("select * from industrytrends where id =#{id}")
    Industrytrends getIndustrytrendsById(int id);

    @Select("select * from industrytrends where industrytrendsName =#{industrytrendsName}")
    Industrytrends getIndustrytrendsByIndustrytrendsName(String industrytrendsName);




}