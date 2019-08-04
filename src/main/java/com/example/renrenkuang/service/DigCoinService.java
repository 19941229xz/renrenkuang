package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.DigCoin;


public interface DigCoinService {



	public Object getAllDigCoin(PageParam<DigCoin> pageParam);

    public boolean removeDigCoinById(int id);

    public Object addDigCoin(DigCoin digCoin);

    public boolean updateDigCoin(DigCoin digCoin);

    public DigCoin getDigCoinById(int id);


}