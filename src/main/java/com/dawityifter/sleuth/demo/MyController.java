package com.dawityifter.sleuth.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    private static Logger logger = LoggerFactory.getLogger(MyController.class);
    private static int counter = 0;
    @GetMapping("/names")
    public int get(){
        logger.info(" Request {} times ", ++counter);
       return counter;
    }
}
