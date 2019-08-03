package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.PointsRule;


public interface PointsRuleService {



	public Object getAllPointsRule(PageParam<PointsRule> pageParam);

    public boolean removePointsRuleById(int id);

    public Object addPointsRule(PointsRule pointsRule);

    public boolean updatePointsRule(PointsRule pointsRule);

    public PointsRule getPointsRuleById(int id);




}