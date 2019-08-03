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
import com.example.renrenkuang.dao.MineDao;
import com.example.renrenkuang.model.Mine;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MineServiceImpl implements MineService {


	@Autowired
    MineDao mineDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllMine(PageParam<Mine> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Mine> mineList=mineDao.getAllMine(pageParam.getModel());
        PageInfo<Mine> minePageInfo = new PageInfo<Mine>(mineList);

        return minePageInfo;
    
    }

	@CacheEvict(value = "mines",key = "#p0")
    @Override
    public boolean removeMineById(int id){
    	return mineDao.removeMineById(id)==1;
    }

	@CachePut(value = "mines",key = "#p0.id")
    @Override
    public Object addMine(Mine mine){
        mineDao.addMine(mine);

        return mineDao.getMineById(mine.getId());
    }

	@CacheEvict(value = "mines",key = "#p0.id")
	@Override
    public boolean updateMine(Mine mine){
    	if(StringUtils.isEmpty(mine.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改mine时，id不能为空");
        }

        return mineDao.updateMine(mine)==1;
    }

	@Cacheable(key = "#p0",value="mines")
    @Override
    @Transactional(readOnly = true)
    public Mine getMineById(int id){
    	return mineDao.getMineById(id);
    	
    }




}
