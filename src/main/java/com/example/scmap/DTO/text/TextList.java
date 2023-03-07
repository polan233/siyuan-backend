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
@ApiModel("TextList 包含课文名、作者名的课文列表")
public class TextList {

    @ApiModelProperty("课文列表")
    private List<TextItem> text_list;

}
