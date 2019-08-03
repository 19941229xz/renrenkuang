package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "Coin" ,description = "币种")
@Data  // 自动生成get set 和构造器
public class Coin implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 币种名
    @ApiModelProperty(value = "币种名" ,name = "name")
	private String name;
	// 币种采矿地址
    @ApiModelProperty(value = "币种采矿地址" ,name = "miningAddress")
	private String miningAddress;
	// 游泳池Hashrate
    @ApiModelProperty(value = "游泳池Hashrate" ,name = "poolHashrate")
	private String poolHashrate;
	// 总的Hashrate
    @ApiModelProperty(value = "总的Hashrate" ,name = "totalHashrate")
	private String totalHashrate;
	// PPS模式输入
    @ApiModelProperty(value = "PPS模式输入" ,name = "PPSModeRevenue")
	private String PPSModeRevenue;
	// rate (币种率)
    @ApiModelProperty(value = "rate (币种率)" ,name = "rate")
	private Double rate;

}