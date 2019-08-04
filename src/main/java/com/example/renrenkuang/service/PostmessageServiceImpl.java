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
import com.example.renrenkuang.dao.PostmessageDao;
import com.example.renrenkuang.model.Postmessage;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PostmessageServiceImpl implements PostmessageService {


	@Autowired
    PostmessageDao postmessageDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllPostmessage(PageParam<Postmessage> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Postmessage> postmessageList=postmessageDao.getAllPostmessage(pageParam.getModel());
        PageInfo<Postmessage> postmessagePageInfo = new PageInfo<Postmessage>(postmessageList);

        return postmessagePageInfo;
    
    }

	@CacheEvict(value = "postmessages",key = "#p0")
    @Override
    public boolean removePostmessageById(int id){
    	return postmessageDao.removePostmessageById(id)==1;
    }

	@CachePut(value = "postmessages",key = "#p0.id")
    @Override
    public Object addPostmessage(Postmessage postmessage){
        postmessageDao.addPostmessage(postmessage);

        return postmessageDao.getPostmessageById(postmessage.getId());
    }

	@CacheEvict(value = "postmessages",key = "#p0.id")
	@Override
    public boolean updatePostmessage(Postmessage postmessage){
    	if(StringUtils.isEmpty(postmessage.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改postmessage时，id不能为空");
        }

        return postmessageDao.updatePostmessage(postmessage)==1;
    }

	@Cacheable(key = "#p0",value="postmessages")
    @Override
    @Transactional(readOnly = true)
    public Postmessage getPostmessageById(int id){
    	return postmessageDao.getPostmessageById(id);
    	
    }
    
    

}
