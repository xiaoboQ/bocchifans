package com.bobo.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "用户表")
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;
    
    @ApiModelProperty("密码")
    private String password;

    //用户表查询主要依靠邮箱账号——邮箱会在注册的时候验证——一个邮箱只能注册一次
    @ApiModelProperty("邮箱地址")
    private String email;

    @ApiModelProperty("账号创建事件")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("账号信息更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
