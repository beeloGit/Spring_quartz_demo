package com.example.springquartzdemo.timer;

import com.example.springquartzdemo.info.TimerInfo;
import com.example.springquartzdemo.util.TimerUtil;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {
    public static final Logger logger= LoggerFactory.getLogger(SchedulerService.class);

    private Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(final Class jobClass, final TimerInfo timerInfo){
        final JobDetail jobDetail = TimerUtil.createJobDetail(jobClass, timerInfo);
        final Trigger trigger = TimerUtil.buildTrigger(jobClass, timerInfo);

        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @PostConstruct
    public void init(){
        try {
            scheduler.start();

        }catch (Exception e){
            logger.error(e.toString());
        }
    }

    @PreDestroy
    public void shutDownScheduler(){
        try {
            scheduler.shutdown();
        }catch (Exception e){
            logger.error(e.toString());
        }
    }
}
