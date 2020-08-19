package com.github.brianmmcclain.springprometheusdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@RestController
public class WebController {

    SimpleMeterRegistry simpleReg = new SimpleMeterRegistry();
    private final Counter visitCounter = Counter
        .builder("demoVisitCounter")
        .description("Number of hits to the / endpoint")
        .tags("dev", "traffic")
        .register(simpleReg);

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