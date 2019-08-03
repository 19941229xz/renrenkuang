package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Mill" ,description = "矿机")
@Data  // 自动生成get set 和构造器
public class Mill implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 品牌id（关联品牌表）
    @ApiModelProperty(value = "品牌id（关联品牌表）" ,name = "brand")
	private Integer brand;
	// 型号id(关联型号表)
    @ApiModelProperty(value = "型号id(关联型号表)" ,name = "model")
	private Integer model;
	// 电源详情（关联电源表）
    @ApiModelProperty(value = "电源详情（关联电源表）" ,name = "powerContent")
	private Integer powerContent;
	// 订单号(选填)
    @ApiModelProperty(value = "订单号(选填)" ,name = "orderId")
	private Integer orderId;
	// 价格
    @ApiModelProperty(value = "价格" ,name = "price")
	private Double price;
	// 币种id
    @ApiModelProperty(value = "币种id" ,name = "bitType")
	private Integer bitType;
	// 是否有显卡（1有 2没有）
    @ApiModelProperty(value = "是否有显卡（1有 2没有）" ,name = "hasGPU")
	private Integer hasGPU;
	// 生产日期
    @ApiModelProperty(value = "生产日期" ,name = "manufactureDate")
	private Date manufactureDate;
	// 数量
    @ApiModelProperty(value = "数量" ,name = "num")
	private Integer num;
	// 是否二手（1二手 2新货）
    @ApiModelProperty(value = "是否二手（1二手 2新货）" ,name = "isUsed")
	private Integer isUsed;

}