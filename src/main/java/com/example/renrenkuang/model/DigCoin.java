package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "DigCoin" ,description = "挖币")
@Data  // 自动生成get set 和构造器
public class DigCoin implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 矿机id （关联矿机表）
    @ApiModelProperty(value = "矿机id （关联矿机表）" ,name = "millId")
	private Integer millId;
	//  币种id（关联币种表）
    @ApiModelProperty(value = " 币种id（关联币种表）" ,name = "coinId")
	private Integer coinId;

}