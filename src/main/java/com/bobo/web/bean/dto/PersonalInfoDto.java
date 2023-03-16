package com.bobo.web.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "个人信息Dto")
public class PersonalInfoDto {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("时间——天")
    private long day;

    @ApiModelProperty("时间——小时")
    private long hour;

    @ApiModelProperty("时间——分钟")
    private long min;

    @ApiModelProperty("时间——秒")
    private long sec;
}
