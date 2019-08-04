package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Postmessage" ,description = "发布信息")
@Data  // 自动生成get set 和构造器
public class Postmessage implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 用户id(关联用户表)
    @ApiModelProperty(value = "用户id(关联用户表)" ,name = "publishUserId")
	private Integer publishUserId;
	// 矿机id(关联矿机表)
    @ApiModelProperty(value = "矿机id(关联矿机表)" ,name = "millId")
	private Integer millId;
	// 发布类型  1:发布出售信息 2:发布求售信息
    @ApiModelProperty(value = "发布类型  1:发布出售信息 2:发布求售信息" ,name = "publishType")
	private Integer publishType;
	// 发布标题
    @ApiModelProperty(value = "发布标题" ,name = "publishTitle")
	private String publishTitle;
	// 发布内容
    @ApiModelProperty(value = "发布内容" ,name = "publishContent")
	private String publishContent;
	// 发布时间
    @ApiModelProperty(value = "发布时间" ,name = "publishTime")
	private Date publishTime;
	// 发布备注
    @ApiModelProperty(value = "发布备注" ,name = "remark")
	private String remark;
	// 联系电话
    @ApiModelProperty(value = "联系电话" ,name = "phone")
	private String phone;
	// 发布地址
    @ApiModelProperty(value = "发布地址" ,name = "releaseAddress")
	private String releaseAddress;
	// 性能图1
    @ApiModelProperty(value = "性能图1" ,name = "performanceChart1")
	private String performanceChart1;
	// 性能图2
    @ApiModelProperty(value = "性能图2" ,name = "performanceChart2")
	private String performanceChart2;
	// 性能图3
    @ApiModelProperty(value = "性能图3" ,name = "performanceChart3")
	private String performanceChart3;
	// 机器SN码照片1
    @ApiModelProperty(value = "机器SN码照片1" ,name = "SNImg1")
	private String SNImg1;
	// 机器SN码照片2
    @ApiModelProperty(value = "机器SN码照片2" ,name = "SNImg2")
	private String SNImg2;
	// 机器SN码照片3
    @ApiModelProperty(value = "机器SN码照片3" ,name = "SNImg3")
	private String SNImg3;
	// 配件外观图1
    @ApiModelProperty(value = "配件外观图1" ,name = "externalView1")
	private String externalView1;
	// 配件外观图2
    @ApiModelProperty(value = "配件外观图2" ,name = "externalView2")
	private String externalView2;
	// 配件外观图3
    @ApiModelProperty(value = "配件外观图3" ,name = "externalView3")
	private String externalView3;
	// 算力图1
    @ApiModelProperty(value = "算力图1" ,name = "computingPowerImg1")
	private String computingPowerImg1;
	// 算力图2
    @ApiModelProperty(value = "算力图2" ,name = "computingPowerImg2")
	private String computingPowerImg2;
	// 算力图3
    @ApiModelProperty(value = "算力图3" ,name = "computingPowerImg3")
	private String computingPowerImg3;
	// 是否置顶(默认未置顶) 1:不置顶 2:置顶
    @ApiModelProperty(value = "是否置顶(默认未置顶) 1:不置顶 2:置顶" ,name = "isStick")
	private Integer isStick;
	// 是否明盘(默认不明盘) 1:不明盘 2:明盘
    @ApiModelProperty(value = "是否明盘(默认不明盘) 1:不明盘 2:明盘" ,name = "isPublic")
	private Integer isPublic;
	// 是否质保(默认不质保) 1:不质保 2:质保
    @ApiModelProperty(value = "是否质保(默认不质保) 1:不质保 2:质保" ,name = "isGuarantee")
	private Integer isGuarantee;
	// 置顶次数
    @ApiModelProperty(value = "置顶次数" ,name = "stickNumber")
	private Integer stickNumber;
	// 经度
    @ApiModelProperty(value = "经度" ,name = "longitude")
	private Double longitude;
	// 维度
    @ApiModelProperty(value = "维度" ,name = "latitude")
	private Double latitude;
	// 浏览次数
    @ApiModelProperty(value = "浏览次数" ,name = "viewCount")
	private Integer viewCount;
	// 评论数
    @ApiModelProperty(value = "评论数" ,name = "commentNum")
	private Integer commentNum;
	// 点赞数
    @ApiModelProperty(value = "点赞数" ,name = "favourNum")
	private Integer favourNum;
	// 发布人头像
    @ApiModelProperty(value = "发布人头像" ,name = "authorPic")
	private String authorPic;
	// 发布人电话
    @ApiModelProperty(value = "发布人电话" ,name = "authorPhone")
	private String authorPhone;
	// 是否审核通过 1未通过  2已审核通过
    @ApiModelProperty(value = "是否审核通过 1未通过  2已审核通过" ,name = "isChecked")
	private Integer isChecked;

}