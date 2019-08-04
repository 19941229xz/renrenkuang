package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Miningpool;
import com.example.renrenkuang.service.MiningpoolService;

import javax.validation.Valid;

@Api(value = "miningpool模块接口",description = "这是一个矿池模块的接口文档")
@RestController
@Slf4j
public class MiningpoolController {

	@Autowired
    MiningpoolService miningpoolService;

	@ApiOperation("查询所有矿池 支持多条件分页排序查询")
    @PostMapping("/getAllMiningpool")
    public Object getAllMiningpool(@RequestBody PageParam<Miningpool> pageParam){
        return MyRsp.success(miningpoolService.getAllMiningpool(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeMiningpoolById/{id}")
    public Object removeMiningpoolByMiningpoolName(@PathVariable("id") int id){

        return miningpoolService.removeMiningpoolById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addMiningpool")
    public Object addMiningpool(@RequestBody @Valid Miningpool miningpoolParam){
        Miningpool miningpool=(Miningpool)miningpoolService.addMiningpool(miningpoolParam);

        return miningpool!=null?MyRsp.success(miningpool).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateMiningpool")
    public Object updateMiningpool(@RequestBody@Valid Miningpool miningpool){
        return miningpoolService.updateMiningpool(miningpool)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getMiningpoolById/{id}")
    public Object getMiningpoolById(@PathVariable("id") int id){

        Miningpool miningpool=miningpoolService.getMiningpoolById(id);
        return miningpool!=null?MyRsp.success(miningpool):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @PostMapping("/batchDeleteMiningpoolByIds")
    public Object batchDeleteMiningpoolByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (miningpoolService.removeMiningpoolById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}