package cn.calfgz.college.statistics.task;

import cn.calfgz.college.statistics.service.DailyService;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-08 10:56
 */
@Component
public class ScheduledTask {

    @Autowired
    private DailyService dailyService;

    /**
     * 每天凌晨1点执行定时
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        //获取上一天的日期
        String day = DateUtil.formatDate(DateUtil.offsetDay(new Date(), -1));
        dailyService.createStatisticsByDay(day);
    }

}
