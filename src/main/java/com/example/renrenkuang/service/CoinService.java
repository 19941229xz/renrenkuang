package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Coin;


public interface CoinService {



	public Object getAllCoin(PageParam<Coin> pageParam);

    public boolean removeCoinById(int id);

    public Object addCoin(Coin coin);

    public boolean updateCoin(Coin coin);

    public Coin getCoinById(int id);




}