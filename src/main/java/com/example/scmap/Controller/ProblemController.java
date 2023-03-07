package com.example.scmap.Controller;

import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.Service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api("考察题目相关操作")
@RestController
@RequestMapping("v1/problem")
@Validated
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    @GetMapping("/problemsById/{id}")
    @ApiOperation(value = "根据id获取课文题目", response = List.class)
    public Result getTextProblemsById(@NotNull @PathVariable("id") Long textId) {
        try{
            return Result.success( problemService.getTextProblemsById(textId) );
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/problemsByName")
    @ApiOperation(value = "根据名称获取课文题目", response = List.class)
    @ApiImplicitParam(name="textName",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextProblemsByName(@NotNull @RequestParam("name") String textName) {
        try{
            return Result.success( problemService.getTextProblemsByName(textName) );
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }
}
