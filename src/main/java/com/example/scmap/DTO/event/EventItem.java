package com.example.scmap.DTO.event;

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
@ApiModel("EventItem 事件列表")
public class EventItem {

    @ApiModelProperty("城市id")
    private Long city;

    @ApiModelProperty("事件")
    private String event;

    @ApiModelProperty("时间")
    private String time;

    @ApiModelProperty("是公元前")
    private Boolean isBC;


}
