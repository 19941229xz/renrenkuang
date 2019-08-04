package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Industrytrends;


public interface IndustrytrendsService {



	public Object getAllIndustrytrends(PageParam<Industrytrends> pageParam);

    public boolean removeIndustrytrendsById(int id);

    public Object addIndustrytrends(Industrytrends industrytrends);

    public boolean updateIndustrytrends(Industrytrends industrytrends);

    public Industrytrends getIndustrytrendsById(int id);


}