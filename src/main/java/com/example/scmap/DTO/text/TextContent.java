package com.example.scmap.DTO.text;

import com.example.scmap.Entity.Addition;
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
@ApiModel("TextContent 包含课文名、课文类型、实词翻译/课后问题")
public class TextContent {

    @ApiModelProperty("课文id")
    private Long textId;

    @ApiModelProperty("课文名")
    private String textName;

    @ApiModelProperty("课文类型 0古文 1现代文")
    private Character type;

    @ApiModelProperty("实词翻译/课后问题")
    private List<Addition> additions;


}
