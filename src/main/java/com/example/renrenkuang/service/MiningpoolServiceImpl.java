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
import com.example.renrenkuang.dao.MiningpoolDao;
import com.example.renrenkuang.model.Miningpool;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MiningpoolServiceImpl implements MiningpoolService {


	@Autowired
    MiningpoolDao miningpoolDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllMiningpool(PageParam<Miningpool> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Miningpool> miningpoolList=miningpoolDao.getAllMiningpool(pageParam.getModel());
        PageInfo<Miningpool> miningpoolPageInfo = new PageInfo<Miningpool>(miningpoolList);

        return miningpoolPageInfo;
    
    }

	@CacheEvict(value = "miningpools",key = "#p0")
    @Override
    public boolean removeMiningpoolById(int id){
    	return miningpoolDao.removeMiningpoolById(id)==1;
    }

	@CachePut(value = "miningpools",key = "#p0.id")
    @Override
    public Object addMiningpool(Miningpool miningpool){
        miningpoolDao.addMiningpool(miningpool);

        return miningpoolDao.getMiningpoolById(miningpool.getId());
    }

	@CacheEvict(value = "miningpools",key = "#p0.id")
	@Override
    public boolean updateMiningpool(Miningpool miningpool){
    	if(StringUtils.isEmpty(miningpool.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改miningpool时，id不能为空");
        }

        return miningpoolDao.updateMiningpool(miningpool)==1;
    }

	@Cacheable(key = "#p0",value="miningpools")
    @Override
    @Transactional(readOnly = true)
    public Miningpool getMiningpoolById(int id){
    	return miningpoolDao.getMiningpoolById(id);
    	
    }




}
