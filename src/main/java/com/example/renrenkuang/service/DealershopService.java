package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Dealershop;


public interface DealershopService {



	public Object getAllDealershop(PageParam<Dealershop> pageParam);

    public boolean removeDealershopById(int id);

    public Object addDealershop(Dealershop dealershop);

    public boolean updateDealershop(Dealershop dealershop);

    public Dealershop getDealershopById(int id);


}