package com.example.springquartzdemo.jobs;

import com.example.springquartzdemo.info.TimerInfo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJob implements Job {
    private Logger logger = LoggerFactory.getLogger(HelloWorldJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        TimerInfo timerInfo =(TimerInfo) dataMap.get(HelloWorldJob.class.getSimpleName());
        logger.info("Hello Word job executing " + timerInfo.getCallbackData());
    }
}
