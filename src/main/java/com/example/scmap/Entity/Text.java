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
@ApiModel("Text 课文")
public class Text {

    @Id
    @ApiModelProperty("课文id")
    private Long textId;

    @ApiModelProperty("课文名")
    private String textName;

    @ApiModelProperty("作者id")
    private Long authorId;

    @ApiModelProperty("发表时间")
    private String publishTime;

    @ApiModelProperty("发表地id")
    private Long publishPlaceId;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("删除标志 0未删除 1已删除")
    private Character delFlag;

    @ApiModelProperty("补充信息")
    private String addition;

    @ApiModelProperty("课本 eg:必修一")
    private String textbook;

    @ApiModelProperty("课文类型 0古文 1现代文")
    private Character type;
}
