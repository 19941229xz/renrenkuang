package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Miningpool;


public interface MiningpoolService {



	public Object getAllMiningpool(PageParam<Miningpool> pageParam);

    public boolean removeMiningpoolById(int id);

    public Object addMiningpool(Miningpool miningpool);

    public boolean updateMiningpool(Miningpool miningpool);

    public Miningpool getMiningpoolById(int id);




}