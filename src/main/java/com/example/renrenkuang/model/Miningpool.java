package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Miningpool" ,description = "矿池")
@Data  // 自动生成get set 和构造器
public class Miningpool implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 矿池名字
    @ApiModelProperty(value = "矿池名字" ,name = "miningPoolName")
	private String miningPoolName;
	// 矿池介绍
    @ApiModelProperty(value = "矿池介绍" ,name = "miningDetail")
	private String miningDetail;
	// 矿池网址
    @ApiModelProperty(value = "矿池网址" ,name = "miningPoolSite")
	private String miningPoolSite;

}