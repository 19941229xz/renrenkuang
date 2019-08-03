package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Dealershop;
import com.example.renrenkuang.service.DealershopService;

import javax.validation.Valid;

@Api(value = "dealershop模块接口",description = "这是一个自营商城模块的接口文档")
@RestController
@Slf4j
public class DealershopController {

	@Autowired
    DealershopService dealershopService;

	@ApiOperation("查询所有自营商城 支持多条件分页排序查询")
    @PostMapping("/getAllDealershop")
    public Object getAllDealershop(@RequestBody PageParam<Dealershop> pageParam){
        return MyRsp.success(dealershopService.getAllDealershop(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeDealershopById/{id}")
    public Object removeDealershopByDealershopName(@PathVariable("id") int id){

        return dealershopService.removeDealershopById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addDealershop")
    public Object addDealershop(@RequestBody @Valid Dealershop dealershopParam){
        Dealershop dealershop=(Dealershop)dealershopService.addDealershop(dealershopParam);

        return dealershop!=null?MyRsp.success(dealershop).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateDealershop")
    public Object updateDealershop(@RequestBody@Valid Dealershop dealershop){
        return dealershopService.updateDealershop(dealershop)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getDealershopById/{id}")
    public Object getDealershopById(@PathVariable("id") int id){

        Dealershop dealershop=dealershopService.getDealershopById(id);
        return dealershop!=null?MyRsp.success(dealershop):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}