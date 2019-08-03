package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.PointsRule;
import com.example.renrenkuang.service.PointsRuleService;

import javax.validation.Valid;

@Api(value = "pointsRule模块接口",description = "这是一个积分规则模块的接口文档")
@RestController
@Slf4j
public class PointsRuleController {

	@Autowired
    PointsRuleService pointsRuleService;

	@ApiOperation("查询所有积分规则 支持多条件分页排序查询")
    @PostMapping("/getAllPointsRule")
    public Object getAllPointsRule(@RequestBody PageParam<PointsRule> pageParam){
        return MyRsp.success(pointsRuleService.getAllPointsRule(pageParam)).msg("查询成功");
    }

    @GetMapping("/removePointsRuleById/{id}")
    public Object removePointsRuleByPointsRuleName(@PathVariable("id") int id){

        return pointsRuleService.removePointsRuleById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addPointsRule")
    public Object addPointsRule(@RequestBody @Valid PointsRule pointsRuleParam){
        PointsRule pointsRule=(PointsRule)pointsRuleService.addPointsRule(pointsRuleParam);

        return pointsRule!=null?MyRsp.success(pointsRule).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updatePointsRule")
    public Object updatePointsRule(@RequestBody@Valid PointsRule pointsRule){
        return pointsRuleService.updatePointsRule(pointsRule)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getPointsRuleById/{id}")
    public Object getPointsRuleById(@PathVariable("id") int id){

        PointsRule pointsRule=pointsRuleService.getPointsRuleById(id);
        return pointsRule!=null?MyRsp.success(pointsRule):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}