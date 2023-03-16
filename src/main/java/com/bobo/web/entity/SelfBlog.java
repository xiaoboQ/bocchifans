package com.bobo.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "个人博客表")
@TableName("self_blog")
public class SelfBlog {

    @TableId(type = IdType.AUTO)
    private Integer id;

    //文章表的查询主要依靠文章标题进行查询
    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章内容")
    private String text;

    @ApiModelProperty("文章创建时间")
    private Date createTime;

    @ApiModelProperty("文章更新时间")
    private Date updateTime;
}
