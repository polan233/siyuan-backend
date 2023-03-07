package com.example.scmap.Controller;

import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.DTO.text.TextItem;
import com.example.scmap.Entity.Text;
import com.example.scmap.Service.TextService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Api("课文相关操作")
@RestController
@RequestMapping("v1/text")
@Validated
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/slideBar")
    @ApiOperation(value = "应用于侧边栏的课文列表", response = List.class)
    public Result getSlideBarTextList() {
        Map<String,List<TextItem>> result = textService.getSlideBarTextList();
        return Result.success(result);
    }

    @GetMapping("/list")
    @ApiOperation(value = "课文列表", response = List.class)
    public Result getTextList() {
        return Result.success(textService.getTextList());
    }

    @GetMapping("/typeById")
    @ApiOperation(value = "根据id获取课文类型", response = Character.class)
    @ApiImplicitParam(name="textId",value="课文id",required = true,paramType = "query",dataType = "Long")
    public Result getTextTypeById(@NotNull @RequestParam("id") Long textId) {
        try {
            return Result.success(textService.getTextTypeById(textId));
        } catch (CommonException e) {
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/info")
    @ApiOperation(value = "根据名称获取课文信息", response = Text.class)
    @ApiImplicitParam(name="textName",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextInformationByName(@NotNull @RequestParam("name") String textName) {
        try {
            return Result.success(textService.getTextInformationByName(textName));
        } catch (CommonException e) {
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/author")
    @ApiOperation(value = "根据名称获取课文作者", response = Text.class)
    @ApiImplicitParam(name="textName",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextAuthorByName(@NotNull @RequestParam("name") String textName) {
        try {
            return Result.success(textService.getTextAuthorByName(textName));
        } catch (CommonException e) {
            return Result.result(e.getCommonErrorCode());
        }
    }

    @GetMapping("/contentByName")
    @ApiOperation(value = "根据名称获取课文内容", response = Character.class)
    @ApiImplicitParam(name="name",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextContentByName(@NotNull @RequestParam("name") String textName) {
        try {
            return Result.success(textService.getTextContentByName(textName));
        } catch (CommonException e) {
            return Result.result(e.getCommonErrorCode());
        }
    }


    @GetMapping("/typeByName")
    @ApiOperation(value = "根据课文名获取课文类型", response = Character.class)
    @ApiImplicitParam(name="name",value="课文名称",required = true,paramType = "query",dataType = "String")
    public Result getTextTypeByName(@NotNull @RequestParam("name") String textName) {
        try{
            return Result.success( textService.getTextTypeByName(textName) );
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }



}
