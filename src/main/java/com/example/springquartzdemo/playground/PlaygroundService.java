package com.example.springquartzdemo.playground;

import com.example.springquartzdemo.info.TimerInfo;
import com.example.springquartzdemo.jobs.HelloWorldJob;
import com.example.springquartzdemo.timer.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {
    private SchedulerService schedulerService;

    @Autowired
    public void PlaygroundService(final SchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    public void runHelloWorldJob(){
        final TimerInfo timerInfo = new TimerInfo();
        timerInfo.setCallbackData("My Callback Data");
        timerInfo.setRunForever(false);
        timerInfo.setInitialOffsetMs(1000L);
        timerInfo.setRepeatIntervalMs(2000L);
        timerInfo.setTotalFireCount(5);

        schedulerService.schedule(HelloWorldJob.class,timerInfo);
    }
}
