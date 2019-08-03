package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Mine;


public interface MineService {



	public Object getAllMine(PageParam<Mine> pageParam);

    public boolean removeMineById(int id);

    public Object addMine(Mine mine);

    public boolean updateMine(Mine mine);

    public Mine getMineById(int id);




}