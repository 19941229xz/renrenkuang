package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Mill;


public interface MillService {



	public Object getAllMill(PageParam<Mill> pageParam);

    public boolean removeMillById(int id);

    public Object addMill(Mill mill);

    public boolean updateMill(Mill mill);

    public Mill getMillById(int id);




}