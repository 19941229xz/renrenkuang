package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Postmessage;


public interface PostmessageService {



	public Object getAllPostmessage(PageParam<Postmessage> pageParam);

    public boolean removePostmessageById(int id);

    public Object addPostmessage(Postmessage postmessage);

    public boolean updatePostmessage(Postmessage postmessage);

    public Postmessage getPostmessageById(int id);


}