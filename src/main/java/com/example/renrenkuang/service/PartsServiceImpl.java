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
import com.example.renrenkuang.dao.PartsDao;
import com.example.renrenkuang.model.Parts;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PartsServiceImpl implements PartsService {


	@Autowired
    PartsDao partsDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllParts(PageParam<Parts> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Parts> partsList=partsDao.getAllParts(pageParam.getModel());
        PageInfo<Parts> partsPageInfo = new PageInfo<Parts>(partsList);

        return partsPageInfo;
    
    }

	@CacheEvict(value = "partss",key = "#p0")
    @Override
    public boolean removePartsById(int id){
    	return partsDao.removePartsById(id)==1;
    }

	@CachePut(value = "partss",key = "#p0.id")
    @Override
    public Object addParts(Parts parts){
        partsDao.addParts(parts);

        return partsDao.getPartsById(parts.getId());
    }

	@CacheEvict(value = "partss",key = "#p0.id")
	@Override
    public boolean updateParts(Parts parts){
    	if(StringUtils.isEmpty(parts.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改parts时，id不能为空");
        }

        return partsDao.updateParts(parts)==1;
    }

	@Cacheable(key = "#p0",value="partss")
    @Override
    @Transactional(readOnly = true)
    public Parts getPartsById(int id){
    	return partsDao.getPartsById(id);
    	
    }




}
