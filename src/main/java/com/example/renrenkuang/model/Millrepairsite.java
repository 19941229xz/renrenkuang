package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Millrepairsite" ,description = "矿机维修地址")
@Data  // 自动生成get set 和构造器
public class Millrepairsite implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 联系电话
    @ApiModelProperty(value = "联系电话" ,name = "phone")
	private String phone;
	// 维修地点
    @ApiModelProperty(value = "维修地点" ,name = "repairSite")
	private String repairSite;
	// 维修店的名字
    @ApiModelProperty(value = "维修店的名字" ,name = "name")
	private String name;

}