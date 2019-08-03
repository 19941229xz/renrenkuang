package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.PointsRule;

import java.util.List;

public interface PointsRuleDao {


    List<PointsRule> getAllPointsRule(PointsRule pointsRule);

    @Delete("delete from pointsRule where id = #{id}")
    int removePointsRuleById(int id);

    int addPointsRule(PointsRule pointsRule);

    int updatePointsRule(PointsRule pointsRule);

    @Select("select * from pointsRule where id =#{id}")
    PointsRule getPointsRuleById(int id);

    @Select("select * from pointsRule where pointsRuleName =#{pointsRuleName}")
    PointsRule getPointsRuleByPointsRuleName(String pointsRuleName);




}