package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Millrepairsite;


public interface MillrepairsiteService {



	public Object getAllMillrepairsite(PageParam<Millrepairsite> pageParam);

    public boolean removeMillrepairsiteById(int id);

    public Object addMillrepairsite(Millrepairsite millrepairsite);

    public boolean updateMillrepairsite(Millrepairsite millrepairsite);

    public Millrepairsite getMillrepairsiteById(int id);


}