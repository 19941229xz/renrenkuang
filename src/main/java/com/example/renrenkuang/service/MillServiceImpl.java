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
import com.example.renrenkuang.dao.MillDao;
import com.example.renrenkuang.model.Mill;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MillServiceImpl implements MillService {


	@Autowired
    MillDao millDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllMill(PageParam<Mill> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Mill> millList=millDao.getAllMill(pageParam.getModel());
        PageInfo<Mill> millPageInfo = new PageInfo<Mill>(millList);

        return millPageInfo;
    
    }

	@CacheEvict(value = "mills",key = "#p0")
    @Override
    public boolean removeMillById(int id){
    	return millDao.removeMillById(id)==1;
    }

	@CachePut(value = "mills",key = "#p0.id")
    @Override
    public Object addMill(Mill mill){
        millDao.addMill(mill);

        return millDao.getMillById(mill.getId());
    }

	@CacheEvict(value = "mills",key = "#p0.id")
	@Override
    public boolean updateMill(Mill mill){
    	if(StringUtils.isEmpty(mill.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改mill时，id不能为空");
        }

        return millDao.updateMill(mill)==1;
    }

	@Cacheable(key = "#p0",value="mills")
    @Override
    @Transactional(readOnly = true)
    public Mill getMillById(int id){
    	return millDao.getMillById(id);
    	
    }
    
    

}
