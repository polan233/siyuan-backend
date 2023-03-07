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
@ApiModel("Discussion 讨论题")
public class Discussion {

    @ApiModelProperty("讨论题id")
    private Long discussionId;

    @ApiModelProperty("题目")
    private String title;

    @ApiModelProperty("课文id")
    private Long textId;
}
