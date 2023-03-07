package com.example.scmap.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("AuthorNode 作者")
public class Author {

    @Id
    @ApiModelProperty("作者id")
    private Long authorId;

    @ApiModelProperty("姓名")
    private String authorName;

    @ApiModelProperty("删除标志 0未删除 1已删除")
    private char delFlag;

    @ApiModelProperty("介绍")
    private String introduction;

    public Author(Author author){
        this.authorId=null;
        this.authorName = author.authorName;
        this.delFlag = author.delFlag;
        this.introduction = author.introduction;
    }
}
