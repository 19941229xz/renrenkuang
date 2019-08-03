package com.example.renrenkuang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.renrenkuang.common.*;
import com.example.renrenkuang.model.Postmessage;
import com.example.renrenkuang.service.PostmessageService;

import javax.validation.Valid;

@Api(value = "postmessage模块接口",description = "这是一个发布信息模块的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class PostmessageController {

	@Autowired
    PostmessageService postmessageService;

	@ApiOperation("查询所有发布信息 支持多条件分页排序查询")
    @PostMapping("/getAllPostmessage")
    public Object getAllPostmessage(@RequestBody PageParam<Postmessage> pageParam){
        return MyRsp.success(postmessageService.getAllPostmessage(pageParam)).msg("查询成功");
    }

    @GetMapping("/removePostmessageById/{id}")
    public Object removePostmessageByPostmessageName(@PathVariable("id") int id){

        return postmessageService.removePostmessageById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addPostmessage")
    public Object addPostmessage(@RequestBody @Valid Postmessage postmessageParam){
        Postmessage postmessage=(Postmessage)postmessageService.addPostmessage(postmessageParam);

        return postmessage!=null?MyRsp.success(postmessage).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updatePostmessage")
    public Object updatePostmessage(@RequestBody@Valid Postmessage postmessage){
        return postmessageService.updatePostmessage(postmessage)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getPostmessageById/{id}")
    public Object getPostmessageById(@PathVariable("id") int id){

        Postmessage postmessage=postmessageService.getPostmessageById(id);
        return postmessage!=null?MyRsp.success(postmessage):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
	
}