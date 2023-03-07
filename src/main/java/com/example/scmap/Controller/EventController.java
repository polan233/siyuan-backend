package com.example.scmap.Controller;

import com.example.scmap.Common.CommonException;
import com.example.scmap.Common.Result;
import com.example.scmap.Service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("事件相关操作")
@RestController
@RequestMapping("v1/event")
@Validated
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/addToNeo4j")
    @ApiOperation(value = "将事件添加到neo4j数据库中，前端请勿调用", response = String.class)
    public Result addEventsToNeo4j() {
        try{
            return Result.success(eventService.addEventsToNeo4j());
        }
        catch (CommonException e){
            return Result.result(e.getCommonErrorCode());
        }
    }
}
