package com.example.scmap.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("CityNode 城市")
public class City {

    @Id
    @ApiModelProperty("城市id")
    private Long cityId;

    @ApiModelProperty("城市名")
    private String name;

    @ApiModelProperty("补充信息1")
    private String ext1;

    @ApiModelProperty("补充信息2")
    private String ext2;

    @ApiModelProperty("删除标志 0未删除 1已删除")
    private char delFlag;

    public City(City city){
        this.cityId = null;
        this.name = city.name;
        this.ext1 = city.ext1;
        this.ext2 = city.ext2;
        this.delFlag = city.delFlag;
    }
}
