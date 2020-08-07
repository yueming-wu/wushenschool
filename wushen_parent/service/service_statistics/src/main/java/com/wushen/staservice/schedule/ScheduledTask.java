package com.wushen.staservice.schedule;

import com.wushen.staservice.service.StatisticsDailyService;
import com.wushen.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 @descriptions
 @author wushen
 @create 2020-08-06 13:26
 */
@Component
public class ScheduledTask {
    @Autowired
    private StatisticsDailyService dailyService;
    /**
     * 每天凌晨1点执行定时
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        //获取上一天的日期
        String day = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        dailyService.createStatisticsByDay(day);

    }
}
