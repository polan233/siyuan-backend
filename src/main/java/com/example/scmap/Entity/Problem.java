package com.example.scmap.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("Problem 题目")
public class Problem {

    @Id
    @ApiModelProperty("题目id")
    private Long problemId;

    @ApiModelProperty("题目内容")
    private String title;

    @ApiModelProperty("参考答案")
    private String answer;

    @ApiModelProperty("课文id")
    private Long textId;

    @ApiModelProperty("问题类型 0默写 1注释 2句子")
    private Integer type;
}
