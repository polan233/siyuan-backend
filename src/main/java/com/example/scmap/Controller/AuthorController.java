package com.example.scmap.Controller;

import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.Service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api("作者相关操作")
@RestController
@RequestMapping("v1/author")
@Validated
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @GetMapping("/addToNeo4j")
    @ApiOperation(value = "将作者添加到neo4j数据库中，前端请勿调用", response = String.class)
    public Result addAuthorsToNeo4j() {
        try{
            return Result.success(authorService.addAuthorsToNeo4j());
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/getPath")
    @ApiOperation(value = "获取作者轨迹", response = List.class)
    @ApiImplicitParam(name="authorName",value="作者姓名",required = true,paramType = "query",dataType = "String")
    public Result getAuthorPath(@NotNull @RequestParam("authorName") String authorName) {
        try{
            return Result.success(authorService.getAuthorPath(authorName));
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }

}
