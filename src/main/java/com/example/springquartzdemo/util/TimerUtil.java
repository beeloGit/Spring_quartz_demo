package com.example.springquartzdemo.util;

import com.example.springquartzdemo.info.TimerInfo;
import org.quartz.*;

import java.util.Date;

public class TimerUtil {
    private TimerUtil(){

    }

    public static JobDetail createJobDetail(final Class jobClass, final TimerInfo timerInfo){

        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), timerInfo);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();

    }

    public static Trigger buildTrigger(final Class jobClass, final TimerInfo timerInfo){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(timerInfo.getRepeatIntervalMs());
        if(timerInfo.isRunForever()){
            builder.repeatForever();
        }else {
            builder.withRepeatCount(timerInfo.getTotalFireCount()-1);
        }
        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis()+ timerInfo.getInitialOffsetMs()) )
                .build();
    }
}
