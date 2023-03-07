package com.example.scmap.Controller;


import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.Service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("城市相关操作")
@RestController
@RequestMapping("v1/city")
@Validated
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/addToNeo4j")
    @ApiOperation(value = "将城市添加到neo4j数据库中，前端请勿调用", response = String.class)
    public Result addCitiesToNeo4j() {
        try{
            return Result.success(cityService.addCitiesToNeo4j());
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }


    @GetMapping("/getIdList")
    @ApiOperation(value = "获取城市id列表", response = String.class)
    public Result getCityIdList() {
        try{
            return Result.success(cityService.getCityIdList());
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }
}
