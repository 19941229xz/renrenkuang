package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Mine" ,description = "矿场")
@Data  // 自动生成get set 和构造器
public class Mine implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 矿场名字
    @ApiModelProperty(value = "矿场名字" ,name = "mineName")
	private String mineName;
	// 矿场图片1
    @ApiModelProperty(value = "矿场图片1" ,name = "minePicture1")
	private String minePicture1;
	// 矿场图片2
    @ApiModelProperty(value = "矿场图片2" ,name = "minePicture2")
	private String minePicture2;
	// 矿场图片3
    @ApiModelProperty(value = "矿场图片3" ,name = "minePicture3")
	private String minePicture3;
	// 矿场图片4
    @ApiModelProperty(value = "矿场图片4" ,name = "minePicture4")
	private String minePicture4;
	// 矿场介绍
    @ApiModelProperty(value = "矿场介绍" ,name = "mineDetail")
	private String mineDetail;
	// 矿场地址
    @ApiModelProperty(value = "矿场地址" ,name = "mineAddress")
	private String mineAddress;
	// 矿场负责人姓名
    @ApiModelProperty(value = "矿场负责人姓名" ,name = "minePrincipalName")
	private String minePrincipalName;
	// 矿场联系电话
    @ApiModelProperty(value = "矿场联系电话" ,name = "phone")
	private String phone;

}