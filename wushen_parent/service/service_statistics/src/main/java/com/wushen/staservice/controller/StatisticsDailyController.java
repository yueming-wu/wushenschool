package com.wushen.staservice.controller;


import com.wushen.commonutils.R;
import com.wushen.staservice.service.StatisticsDailyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-06
 */
@Api(tags = "后台统计管理")
@RestController
@RequestMapping("/staservice/daily")
@CrossOrigin
public class StatisticsDailyController {
    @Autowired
    private StatisticsDailyService dailyService;
    @ApiOperation(value = "统计注册",notes = "统计当天注册人数")
    @PostMapping("/{day}")
    public R createStatisticsByDate(@ApiParam(name = "day",value = "当天时间",required = true)
                                    @PathVariable String day) {
        dailyService.createStatisticsByDay(day);
        return R.ok();
    }
    @ApiOperation(value = "获取数据",notes = "根据统计因子和时间获取数据")
    @GetMapping("/getData/{type}/{begin}/{end}")
    public R getDataByType(@ApiParam(name = "type",value = "统计因子",required = true)
                           @PathVariable String type,
                           @ApiParam(name = "begin",value = "开始时间",required = true)
                           @PathVariable String begin,
                           @ApiParam(name = "end",value = "结束时间",required = true)
                           @PathVariable String end){
        Map<String,Object> map = dailyService.getData(type,begin,end);
        return R.ok().data("map",map);
    }

}

