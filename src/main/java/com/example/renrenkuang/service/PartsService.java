package com.example.renrenkuang.service;

import com.example.renrenkuang.common.PageParam;
import com.example.renrenkuang.model.Parts;


public interface PartsService {



	public Object getAllParts(PageParam<Parts> pageParam);

    public boolean removePartsById(int id);

    public Object addParts(Parts parts);

    public boolean updateParts(Parts parts);

    public Parts getPartsById(int id);


}