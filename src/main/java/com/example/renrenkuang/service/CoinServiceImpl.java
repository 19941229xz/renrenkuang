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
import com.example.renrenkuang.dao.CoinDao;
import com.example.renrenkuang.model.Coin;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CoinServiceImpl implements CoinService {


	@Autowired
    CoinDao coinDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllCoin(PageParam<Coin> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Coin> coinList=coinDao.getAllCoin(pageParam.getModel());
        PageInfo<Coin> coinPageInfo = new PageInfo<Coin>(coinList);

        return coinPageInfo;
    
    }

	@CacheEvict(value = "coins",key = "#p0")
    @Override
    public boolean removeCoinById(int id){
    	return coinDao.removeCoinById(id)==1;
    }

	@CachePut(value = "coins",key = "#p0.id")
    @Override
    public Object addCoin(Coin coin){
        coinDao.addCoin(coin);

        return coinDao.getCoinById(coin.getId());
    }

	@CacheEvict(value = "coins",key = "#p0.id")
	@Override
    public boolean updateCoin(Coin coin){
    	if(StringUtils.isEmpty(coin.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改coin时，id不能为空");
        }

        return coinDao.updateCoin(coin)==1;
    }

	@Cacheable(key = "#p0",value="coins")
    @Override
    @Transactional(readOnly = true)
    public Coin getCoinById(int id){
    	return coinDao.getCoinById(id);
    	
    }




}
