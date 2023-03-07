package com.example.scmap.Controller;


import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.DTO.text.TextContent;
import com.example.scmap.Service.AdditionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api("注释/课后题相关操作")
@RestController
@RequestMapping("v1/addition")
@Validated
public class AdditionController {

    @Autowired
    private AdditionService additionService;

    @GetMapping("/contentById")
    @ApiOperation(value = "根据id获取课文内容", response = TextContent.class)
    @ApiImplicitParam(name="textId",value="课文id",required = true,paramType = "query",dataType = "Long")
    public Result getTextContentById(@NotNull @RequestParam("id") Long textId) {
        try{
            return Result.success( additionService.getTextContentById(textId) );
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/contentByName")
    @ApiOperation(value = "根据名称获取课文内容", response = TextContent.class)
    @ApiImplicitParam(name="textName",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextContentByName(@NotNull @RequestParam("name") String textName) {
        try{
            return Result.success( additionService.getTextContentByName(textName) );
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }
}
