package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Parts" ,description = "配件表")
@Data  // 自动生成get set 和构造器
public class Parts implements Serializable {
	// 配件主键id
    @ApiModelProperty(value = "配件主键id" ,name = "id")
	private Integer id;
	// 配件类型
    @ApiModelProperty(value = "配件类型" ,name = "partsType")
	private String partsType;
	// 配件名称
    @ApiModelProperty(value = "配件名称" ,name = "partsName")
	private String partsName;
	// 是否二手 1 是二手 2 不是二手
    @ApiModelProperty(value = "是否二手 1 是二手 2 不是二手" ,name = "isSecondHand")
	private Integer isSecondHand;
	// 配件描述
    @ApiModelProperty(value = "配件描述" ,name = "description")
	private String description;
	// 配件价格
    @ApiModelProperty(value = "配件价格" ,name = "price")
	private Double price;
	// 配件外观1
    @ApiModelProperty(value = "配件外观1" ,name = "externalView1")
	private String externalView1;
	// 配件外观2
    @ApiModelProperty(value = "配件外观2" ,name = "externalView2")
	private String externalView2;
	// 配件外观3
    @ApiModelProperty(value = "配件外观3" ,name = "externalView3")
	private String externalView3;
	// 性能图1
    @ApiModelProperty(value = "性能图1" ,name = "performanceImg1")
	private String performanceImg1;
	// 性能图2
    @ApiModelProperty(value = "性能图2" ,name = "performanceImg2")
	private String performanceImg2;
	// 性能图3
    @ApiModelProperty(value = "性能图3" ,name = "performanceImg3")
	private String performanceImg3;
	// 是否在保质期 1是 2 不是
    @ApiModelProperty(value = "是否在保质期 1是 2 不是" ,name = "isWarrantyPeriod")
	private Integer isWarrantyPeriod;
	// 出厂日期
    @ApiModelProperty(value = "出厂日期" ,name = "manufactureDate")
	private Date manufactureDate;
	// 不在质保期是否提供店保 1 是 2 不是
    @ApiModelProperty(value = "不在质保期是否提供店保 1 是 2 不是" ,name = "isShopIsProtected")
	private Integer isShopIsProtected;

}