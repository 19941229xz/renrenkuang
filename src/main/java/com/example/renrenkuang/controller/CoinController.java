package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Coin;
import com.example.renrenkuang.service.CoinService;

import javax.validation.Valid;

@Api(value = "coin模块接口",description = "这是一个币种模块的接口文档")
@RestController
@Slf4j
public class CoinController {

	@Autowired
    CoinService coinService;

	@ApiOperation("查询所有币种 支持多条件分页排序查询")
    @PostMapping("/getAllCoin")
    public Object getAllCoin(@RequestBody PageParam<Coin> pageParam){
        return MyRsp.success(coinService.getAllCoin(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeCoinById/{id}")
    public Object removeCoinByCoinName(@PathVariable("id") int id){

        return coinService.removeCoinById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addCoin")
    public Object addCoin(@RequestBody @Valid Coin coinParam){
        Coin coin=(Coin)coinService.addCoin(coinParam);

        return coin!=null?MyRsp.success(coin).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateCoin")
    public Object updateCoin(@RequestBody@Valid Coin coin){
        return coinService.updateCoin(coin)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getCoinById/{id}")
    public Object getCoinById(@PathVariable("id") int id){

        Coin coin=coinService.getCoinById(id);
        return coin!=null?MyRsp.success(coin):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}