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
import com.example.renrenkuang.dao.DigCoinDao;
import com.example.renrenkuang.model.DigCoin;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DigCoinServiceImpl implements DigCoinService {


	@Autowired
    DigCoinDao digCoinDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllDigCoin(PageParam<DigCoin> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<DigCoin> digCoinList=digCoinDao.getAllDigCoin(pageParam.getModel());
        PageInfo<DigCoin> digCoinPageInfo = new PageInfo<DigCoin>(digCoinList);

        return digCoinPageInfo;
    
    }

	@CacheEvict(value = "digCoins",key = "#p0")
    @Override
    public boolean removeDigCoinById(int id){
    	return digCoinDao.removeDigCoinById(id)==1;
    }

	@CachePut(value = "digCoins",key = "#p0.id")
    @Override
    public Object addDigCoin(DigCoin digCoin){
        digCoinDao.addDigCoin(digCoin);

        return digCoinDao.getDigCoinById(digCoin.getId());
    }

	@CacheEvict(value = "digCoins",key = "#p0.id")
	@Override
    public boolean updateDigCoin(DigCoin digCoin){
    	if(StringUtils.isEmpty(digCoin.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改digCoin时，id不能为空");
        }

        return digCoinDao.updateDigCoin(digCoin)==1;
    }

	@Cacheable(key = "#p0",value="digCoins")
    @Override
    @Transactional(readOnly = true)
    public DigCoin getDigCoinById(int id){
    	return digCoinDao.getDigCoinById(id);
    	
    }
    
    

}
