package com.example.renrenkuang.dao;

import org.apache.ibatis.annotations.*;
import com.example.renrenkuang.model.Miningpool;

import java.util.List;

public interface MiningpoolDao {


    List<Miningpool> getAllMiningpool(Miningpool miningpool);

    @Delete("delete from miningpool where id = #{id}")
    int removeMiningpoolById(int id);

    int addMiningpool(Miningpool miningpool);

    int updateMiningpool(Miningpool miningpool);

    @Select("select * from miningpool where id =#{id}")
    Miningpool getMiningpoolById(int id);

    @Select("select * from miningpool where miningpoolName =#{miningpoolName}")
    Miningpool getMiningpoolByMiningpoolName(String miningpoolName);




}