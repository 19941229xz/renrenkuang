package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Mine;
import com.example.renrenkuang.service.MineService;

import javax.validation.Valid;

@Api(value = "mine模块接口",description = "这是一个矿场模块的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class MineController {

	@Autowired
    MineService mineService;

	@ApiOperation("查询所有矿场 支持多条件分页排序查询")
    @PostMapping("/getAllMine")
    public Object getAllMine(@RequestBody PageParam<Mine> pageParam){
        return MyRsp.success(mineService.getAllMine(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeMineById/{id}")
    public Object removeMineByMineName(@PathVariable("id") int id){

        return mineService.removeMineById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addMine")
    public Object addMine(@RequestBody @Valid Mine mineParam){
        Mine mine=(Mine)mineService.addMine(mineParam);

        return mine!=null?MyRsp.success(mine).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateMine")
    public Object updateMine(@RequestBody@Valid Mine mine){
        return mineService.updateMine(mine)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getMineById/{id}")
    public Object getMineById(@PathVariable("id") int id){

        Mine mine=mineService.getMineById(id);
        return mine!=null?MyRsp.success(mine):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}