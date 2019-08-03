package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Industrytrends;
import com.example.renrenkuang.service.IndustrytrendsService;

import javax.validation.Valid;

@Api(value = "industrytrends模块接口",description = "这是一个行业动态模块的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class IndustrytrendsController {

	@Autowired
    IndustrytrendsService industrytrendsService;

	@ApiOperation("查询所有行业动态 支持多条件分页排序查询")
    @PostMapping("/getAllIndustrytrends")
    public Object getAllIndustrytrends(@RequestBody PageParam<Industrytrends> pageParam){
        return MyRsp.success(industrytrendsService.getAllIndustrytrends(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeIndustrytrendsById/{id}")
    public Object removeIndustrytrendsByIndustrytrendsName(@PathVariable("id") int id){

        return industrytrendsService.removeIndustrytrendsById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addIndustrytrends")
    public Object addIndustrytrends(@RequestBody @Valid Industrytrends industrytrendsParam){
        Industrytrends industrytrends=(Industrytrends)industrytrendsService.addIndustrytrends(industrytrendsParam);

        return industrytrends!=null?MyRsp.success(industrytrends).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateIndustrytrends")
    public Object updateIndustrytrends(@RequestBody@Valid Industrytrends industrytrends){
        return industrytrendsService.updateIndustrytrends(industrytrends)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getIndustrytrendsById/{id}")
    public Object getIndustrytrendsById(@PathVariable("id") int id){

        Industrytrends industrytrends=industrytrendsService.getIndustrytrendsById(id);
        return industrytrends!=null?MyRsp.success(industrytrends):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}