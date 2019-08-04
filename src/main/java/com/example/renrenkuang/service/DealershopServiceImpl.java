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
import com.example.renrenkuang.dao.DealershopDao;
import com.example.renrenkuang.model.Dealershop;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DealershopServiceImpl implements DealershopService {


	@Autowired
    DealershopDao dealershopDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllDealershop(PageParam<Dealershop> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Dealershop> dealershopList=dealershopDao.getAllDealershop(pageParam.getModel());
        PageInfo<Dealershop> dealershopPageInfo = new PageInfo<Dealershop>(dealershopList);

        return dealershopPageInfo;
    
    }

	@CacheEvict(value = "dealershops",key = "#p0")
    @Override
    public boolean removeDealershopById(int id){
    	return dealershopDao.removeDealershopById(id)==1;
    }

	@CachePut(value = "dealershops",key = "#p0.id")
    @Override
    public Object addDealershop(Dealershop dealershop){
        dealershopDao.addDealershop(dealershop);

        return dealershopDao.getDealershopById(dealershop.getId());
    }

	@CacheEvict(value = "dealershops",key = "#p0.id")
	@Override
    public boolean updateDealershop(Dealershop dealershop){
    	if(StringUtils.isEmpty(dealershop.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改dealershop时，id不能为空");
        }

        return dealershopDao.updateDealershop(dealershop)==1;
    }

	@Cacheable(key = "#p0",value="dealershops")
    @Override
    @Transactional(readOnly = true)
    public Dealershop getDealershopById(int id){
    	return dealershopDao.getDealershopById(id);
    	
    }
    
    

}
