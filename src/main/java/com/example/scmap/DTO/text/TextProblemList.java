package com.example.scmap.DTO.text;

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
@ApiModel("TextProblemList 课文题目，分默写、注释翻译、句子翻译")
public class TextProblemList {

    @ApiModelProperty("默写题目与答案")
    private ProblemList moxie;

    @ApiModelProperty("注释翻译题目与答案")
    private ProblemList zhushi;

    @ApiModelProperty("句子翻译题目与答案")
    private ProblemList juzi;



}
