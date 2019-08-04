package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Millrepairsite;
import com.example.renrenkuang.service.MillrepairsiteService;

import javax.validation.Valid;

@Api(value = "millrepairsite模块接口",description = "这是一个矿机维修地址模块的接口文档")
@RestController
@Slf4j
public class MillrepairsiteController {

	@Autowired
    MillrepairsiteService millrepairsiteService;

	@ApiOperation("查询所有矿机维修地址 支持多条件分页排序查询")
    @PostMapping("/getAllMillrepairsite")
    public Object getAllMillrepairsite(@RequestBody PageParam<Millrepairsite> pageParam){
        return MyRsp.success(millrepairsiteService.getAllMillrepairsite(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeMillrepairsiteById/{id}")
    public Object removeMillrepairsiteByMillrepairsiteName(@PathVariable("id") int id){

        return millrepairsiteService.removeMillrepairsiteById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addMillrepairsite")
    public Object addMillrepairsite(@RequestBody @Valid Millrepairsite millrepairsiteParam){
        Millrepairsite millrepairsite=(Millrepairsite)millrepairsiteService.addMillrepairsite(millrepairsiteParam);

        return millrepairsite!=null?MyRsp.success(millrepairsite).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateMillrepairsite")
    public Object updateMillrepairsite(@RequestBody@Valid Millrepairsite millrepairsite){
        return millrepairsiteService.updateMillrepairsite(millrepairsite)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getMillrepairsiteById/{id}")
    public Object getMillrepairsiteById(@PathVariable("id") int id){

        Millrepairsite millrepairsite=millrepairsiteService.getMillrepairsiteById(id);
        return millrepairsite!=null?MyRsp.success(millrepairsite):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @PostMapping("/batchDeleteMillrepairsiteByIds")
    public Object batchDeleteMillrepairsiteByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (millrepairsiteService.removeMillrepairsiteById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}