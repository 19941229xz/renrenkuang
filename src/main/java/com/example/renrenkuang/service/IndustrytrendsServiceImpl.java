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
import com.example.renrenkuang.dao.IndustrytrendsDao;
import com.example.renrenkuang.model.Industrytrends;

import java.util.List;

@Slf4j
@Service
@Transactional
public class IndustrytrendsServiceImpl implements IndustrytrendsService {


	@Autowired
    IndustrytrendsDao industrytrendsDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllIndustrytrends(PageParam<Industrytrends> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Industrytrends> industrytrendsList=industrytrendsDao.getAllIndustrytrends(pageParam.getModel());
        PageInfo<Industrytrends> industrytrendsPageInfo = new PageInfo<Industrytrends>(industrytrendsList);

        return industrytrendsPageInfo;
    
    }

	@CacheEvict(value = "industrytrendss",key = "#p0")
    @Override
    public boolean removeIndustrytrendsById(int id){
    	return industrytrendsDao.removeIndustrytrendsById(id)==1;
    }

	@CachePut(value = "industrytrendss",key = "#p0.id")
    @Override
    public Object addIndustrytrends(Industrytrends industrytrends){
        industrytrendsDao.addIndustrytrends(industrytrends);

        return industrytrendsDao.getIndustrytrendsById(industrytrends.getId());
    }

	@CacheEvict(value = "industrytrendss",key = "#p0.id")
	@Override
    public boolean updateIndustrytrends(Industrytrends industrytrends){
    	if(StringUtils.isEmpty(industrytrends.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改industrytrends时，id不能为空");
        }

        return industrytrendsDao.updateIndustrytrends(industrytrends)==1;
    }

	@Cacheable(key = "#p0",value="industrytrendss")
    @Override
    @Transactional(readOnly = true)
    public Industrytrends getIndustrytrendsById(int id){
    	return industrytrendsDao.getIndustrytrendsById(id);
    	
    }
    
    

}
