package com.example.scmap.Controller;

import com.example.scmap.Common.Result;
import com.example.scmap.Service.DiscussionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api("讨论题相关操作")
@RestController
@RequestMapping("v1/discussion")
@Validated
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/textId")
    @ApiOperation(value = "根据课文id获取讨论题列表", response = List.class)
    @ApiImplicitParam(name = "textId", value = "课文id", required = true, paramType = "query", dataType = "Long")
    public Result getDiscussionListByTextId(@NotNull @RequestParam("textId") Long textId) {
        return Result.success(discussionService.getDiscussionListByTextId(textId));
    }

    @GetMapping("/textName")
    @ApiOperation(value = "根据课文名称获取讨论题列表", response = List.class)
    @ApiImplicitParam(name = "textName", value = "课文名称", required = true, paramType = "query", dataType = "String")
    public Result getDiscussionListByTextName(@NotNull @RequestParam("textName") String textName) {
        return Result.success(discussionService.getDiscussionListByTextName(textName));
    }
}
