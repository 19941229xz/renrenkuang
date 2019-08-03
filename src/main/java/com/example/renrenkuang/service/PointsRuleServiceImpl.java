package com.example.renrenkuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.example.renrenkuang.common.HttpCode;
import com.example.renrenkuang.common.MyException;
import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.dao.PointsRuleDao;
import com.example.renrenkuang.model.PointsRule;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PointsRuleServiceImpl implements PointsRuleService {


	@Autowired
    PointsRuleDao pointsRuleDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllPointsRule(PageParam<PointsRule> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<PointsRule> pointsRuleList=pointsRuleDao.getAllPointsRule(pageParam.getModel());
        PageInfo<PointsRule> pointsRulePageInfo = new PageInfo<PointsRule>(pointsRuleList);

        return pointsRulePageInfo;
    
    }

	@CacheEvict(value = "pointsRules",key = "#p0")
    @Override
    public boolean removePointsRuleById(int id){
    	return pointsRuleDao.removePointsRuleById(id)==1;
    }

	@CachePut(value = "pointsRules",key = "#p0.id")
    @Override
    public Object addPointsRule(PointsRule pointsRule){
        pointsRuleDao.addPointsRule(pointsRule);

        return pointsRuleDao.getPointsRuleById(pointsRule.getId());
    }

	@CacheEvict(value = "pointsRules",key = "#p0.id")
	@Override
    public boolean updatePointsRule(PointsRule pointsRule){
    	if(StringUtils.isEmpty(pointsRule.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改pointsRule时，id不能为空");
        }

        return pointsRuleDao.updatePointsRule(pointsRule)==1;
    }

	@Cacheable(key = "#p0",value="pointsRules")
    @Override
    @Transactional(readOnly = true)
    public PointsRule getPointsRuleById(int id){
    	return pointsRuleDao.getPointsRuleById(id);
    	
    }




}
