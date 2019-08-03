package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Parts;
import com.example.renrenkuang.service.PartsService;

import javax.validation.Valid;

@Api(value = "parts模块接口",description = "这是一个配件表模块的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class PartsController {

	@Autowired
    PartsService partsService;

	@ApiOperation("查询所有配件表 支持多条件分页排序查询")
    @PostMapping("/getAllParts")
    public Object getAllParts(@RequestBody PageParam<Parts> pageParam){
        return MyRsp.success(partsService.getAllParts(pageParam)).msg("查询成功");
    }

    @GetMapping("/removePartsById/{id}")
    public Object removePartsByPartsName(@PathVariable("id") int id){

        return partsService.removePartsById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addParts")
    public Object addParts(@RequestBody @Valid Parts partsParam){
        Parts parts=(Parts)partsService.addParts(partsParam);

        return parts!=null?MyRsp.success(parts).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateParts")
    public Object updateParts(@RequestBody@Valid Parts parts){
        return partsService.updateParts(parts)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getPartsById/{id}")
    public Object getPartsById(@PathVariable("id") int id){

        Parts parts=partsService.getPartsById(id);
        return parts!=null?MyRsp.success(parts):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}