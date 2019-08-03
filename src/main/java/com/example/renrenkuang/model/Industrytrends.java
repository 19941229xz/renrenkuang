package com.example.renrenkuang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Industrytrends" ,description = "行业动态")
@Data  // 自动生成get set 和构造器
public class Industrytrends implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 作者 如未登录，为游客，如已登录，为userName
    @ApiModelProperty(value = "作者 如未登录，为游客，如已登录，为userName" ,name = "author")
	private String author;
	// 标题
    @ApiModelProperty(value = "标题" ,name = "trendTitle")
	private String trendTitle;
	// 头像
    @ApiModelProperty(value = "头像" ,name = "headPic")
	private String headPic;
	// 内容
    @ApiModelProperty(value = "内容" ,name = "content")
	private String content;
	// 发布时间
    @ApiModelProperty(value = "发布时间" ,name = "issueTime")
	private Date issueTime;
	// 评论
    @ApiModelProperty(value = "评论" ,name = "comment")
	private String comment;
	// 评论条数
    @ApiModelProperty(value = "评论条数" ,name = "commentNum")
	private String commentNum;
	// 点赞数
    @ApiModelProperty(value = "点赞数" ,name = "favourNum")
	private Integer favourNum;

}