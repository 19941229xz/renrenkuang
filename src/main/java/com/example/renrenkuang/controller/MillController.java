package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Mill;
import com.example.renrenkuang.service.MillService;

import javax.validation.Valid;

@Api(value = "mill模块接口",description = "这是一个矿机模块的接口文档")
@RestController
@Slf4j
public class MillController {

	@Autowired
    MillService millService;

	@ApiOperation("查询所有矿机 支持多条件分页排序查询")
    @PostMapping("/getAllMill")
    public Object getAllMill(@RequestBody PageParam<Mill> pageParam){
        return MyRsp.success(millService.getAllMill(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeMillById/{id}")
    public Object removeMillByMillName(@PathVariable("id") int id){

        return millService.removeMillById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addMill")
    public Object addMill(@RequestBody @Valid Mill millParam){
        Mill mill=(Mill)millService.addMill(millParam);

        return mill!=null?MyRsp.success(mill).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateMill")
    public Object updateMill(@RequestBody@Valid Mill mill){
        return millService.updateMill(mill)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getMillById/{id}")
    public Object getMillById(@PathVariable("id") int id){

        Mill mill=millService.getMillById(id);
        return mill!=null?MyRsp.success(mill):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}