package com.example.springquartzdemo.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaygroundController {

    @Autowired
    private PlaygroundService playgroundService;

    @GetMapping("/run/job")
    public void runHelloWorldJob(){
        playgroundService.runHelloWorldJob();
    }
}
