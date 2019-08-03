package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Dealershop" ,description = "自营商城")
@Data  // 自动生成get set 和构造器
public class Dealershop implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 用户id(关联用户表)
    @ApiModelProperty(value = "用户id(关联用户表)" ,name = "sellerUserId")
	private Integer sellerUserId;
	// 零件id(关联零件表)
    @ApiModelProperty(value = "零件id(关联零件表)" ,name = "sellPartId")
	private Integer sellPartId;
	// 矿机id(关联矿机表)
    @ApiModelProperty(value = "矿机id(关联矿机表)" ,name = "sellMillId")
	private Integer sellMillId;
	// 卖家名称
    @ApiModelProperty(value = "卖家名称" ,name = "sellerName")
	private String sellerName;
	// 卖家头像
    @ApiModelProperty(value = "卖家头像" ,name = "sellerPic")
	private String sellerPic;
	// 卖家联系电话
    @ApiModelProperty(value = "卖家联系电话" ,name = "sellerPhone")
	private String sellerPhone;
	// 商品名称
    @ApiModelProperty(value = "商品名称" ,name = "productName")
	private String productName;
	// 商品详情
    @ApiModelProperty(value = "商品详情" ,name = "productDetails")
	private String productDetails;
	// 商品图片
    @ApiModelProperty(value = "商品图片" ,name = "productPic")
	private String productPic;

}