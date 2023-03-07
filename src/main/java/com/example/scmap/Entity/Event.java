package com.example.scmap.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Event 事件")
public class Event {

    @ApiModelProperty("事件id")
    private Long eventId;

    @ApiModelProperty("事件描述")
    private String description;

    @ApiModelProperty("作者id")
    private Long authorId;

    @ApiModelProperty("时间")
    private String time;

    @ApiModelProperty("地点id")
    private Long placeId;

    @ApiModelProperty("删除标志 0未删除 1已删除")
    private char delFlag;

    @ApiModelProperty("0公元前 1公元后")
    private int BC;
}
