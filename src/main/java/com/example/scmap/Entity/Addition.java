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
@ApiModel("Addition 课文补充内容")
public class Addition {

    @Id
    @ApiModelProperty("id")
    private Long additionId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("课文id")
    private Long textId;

}
