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
import com.example.renrenkuang.dao.MillrepairsiteDao;
import com.example.renrenkuang.model.Millrepairsite;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MillrepairsiteServiceImpl implements MillrepairsiteService {


	@Autowired
    MillrepairsiteDao millrepairsiteDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllMillrepairsite(PageParam<Millrepairsite> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Millrepairsite> millrepairsiteList=millrepairsiteDao.getAllMillrepairsite(pageParam.getModel());
        PageInfo<Millrepairsite> millrepairsitePageInfo = new PageInfo<Millrepairsite>(millrepairsiteList);

        return millrepairsitePageInfo;
    
    }

	@CacheEvict(value = "millrepairsites",key = "#p0")
    @Override
    public boolean removeMillrepairsiteById(int id){
    	return millrepairsiteDao.removeMillrepairsiteById(id)==1;
    }

	@CachePut(value = "millrepairsites",key = "#p0.id")
    @Override
    public Object addMillrepairsite(Millrepairsite millrepairsite){
        millrepairsiteDao.addMillrepairsite(millrepairsite);

        return millrepairsiteDao.getMillrepairsiteById(millrepairsite.getId());
    }

	@CacheEvict(value = "millrepairsites",key = "#p0.id")
	@Override
    public boolean updateMillrepairsite(Millrepairsite millrepairsite){
    	if(StringUtils.isEmpty(millrepairsite.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改millrepairsite时，id不能为空");
        }

        return millrepairsiteDao.updateMillrepairsite(millrepairsite)==1;
    }

	@Cacheable(key = "#p0",value="millrepairsites")
    @Override
    @Transactional(readOnly = true)
    public Millrepairsite getMillrepairsiteById(int id){
    	return millrepairsiteDao.getMillrepairsiteById(id);
    	
    }




}
