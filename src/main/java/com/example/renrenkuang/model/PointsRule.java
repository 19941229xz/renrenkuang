package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "PointsRule" ,description = "积分规则")
@Data  // 自动生成get set 和构造器
public class PointsRule implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 规则名称
    @ApiModelProperty(value = "规则名称" ,name = "ruleName")
	private String ruleName;
	// 比例
    @ApiModelProperty(value = "比例" ,name = "scale")
	private Integer scale;
	// 单位
    @ApiModelProperty(value = "单位" ,name = "unit")
	private String unit;
	// 类型  1代表入  -1代表出
    @ApiModelProperty(value = "类型  1代表入  -1代表出" ,name = "type")
	private Integer type;
	// 规则描述
    @ApiModelProperty(value = "规则描述" ,name = "description")
	private String description;

}