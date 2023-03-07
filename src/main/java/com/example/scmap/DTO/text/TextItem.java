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
@ApiModel("TextItem 包含课文名、作者名的课文项")
public class TextItem {

    @ApiModelProperty("课文名")
    private String textName;

    @ApiModelProperty("作者姓名")
    private String authorName;

    @ApiModelProperty("课本")
    private String textbook;

}
