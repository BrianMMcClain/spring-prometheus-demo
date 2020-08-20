package com.github.brianmmcclain.springprometheusdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class WebController {

    Counter visitCounter;

    public WebController(MeterRegistry registry) {
        visitCounter = Counter.builder("visit_counter")
            .description("Number of visits to the site")
            .register(registry);
    }

    @GetMapping("/")
    public String index() {
        visitCounter.increment();
        return "Hello World!";
    }

    @GetMapping("/visits")
    public double visitCount() {
        return visitCounter.count();
    }
    
}