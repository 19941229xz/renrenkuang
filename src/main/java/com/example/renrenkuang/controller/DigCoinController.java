package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.DigCoin;
import com.example.renrenkuang.service.DigCoinService;

import javax.validation.Valid;

@Api(value = "digCoin模块接口",description = "这是一个挖币模块的接口文档")
@RestController
@Slf4j
public class DigCoinController {

	@Autowired
    DigCoinService digCoinService;

	@ApiOperation("查询所有挖币 支持多条件分页排序查询")
    @PostMapping("/getAllDigCoin")
    public Object getAllDigCoin(@RequestBody PageParam<DigCoin> pageParam){
        return MyRsp.success(digCoinService.getAllDigCoin(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeDigCoinById/{id}")
    public Object removeDigCoinByDigCoinName(@PathVariable("id") int id){

        return digCoinService.removeDigCoinById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addDigCoin")
    public Object addDigCoin(@RequestBody @Valid DigCoin digCoinParam){
        DigCoin digCoin=(DigCoin)digCoinService.addDigCoin(digCoinParam);

        return digCoin!=null?MyRsp.success(digCoin).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateDigCoin")
    public Object updateDigCoin(@RequestBody@Valid DigCoin digCoin){
        return digCoinService.updateDigCoin(digCoin)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getDigCoinById/{id}")
    public Object getDigCoinById(@PathVariable("id") int id){

        DigCoin digCoin=digCoinService.getDigCoinById(id);
        return digCoin!=null?MyRsp.success(digCoin):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @PostMapping("/batchDeleteDigCoinByIds")
    public Object batchDeleteDigCoinByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (digCoinService.removeDigCoinById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}