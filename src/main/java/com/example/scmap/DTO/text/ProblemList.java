package com.example.scmap.DTO.text;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("ProblemList 题目列表")
public class ProblemList {

    @ApiModelProperty("题目")
    private List<String> problems;

    @ApiModelProperty("答案")
    private List<String> answers;

}
