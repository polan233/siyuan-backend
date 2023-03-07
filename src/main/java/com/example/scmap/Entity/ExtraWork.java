package com.example.scmap.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("ExtraWork 课外作品")
public class ExtraWork {

    @ApiModelProperty("作品id")
    private Long extraWorkId;

    @ApiModelProperty("作品名")
    private String name;

    @ApiModelProperty("作者id")
    private Long authorId;

    @ApiModelProperty("发表时间")
    private Date publishTime;

    @ApiModelProperty("链接地址")
    private String url;

    @ApiModelProperty("删除标志 0未删除 1已删除")
    private char delFlag;

    @ApiModelProperty("补充信息1")
    private String ext1;

}
