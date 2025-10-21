package fr.takima.training.simpleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    record Greeting(long id, String content) {}

    @GetMapping("/")
    public Greeting greeting(String name) {
        String who = (name == null || name.isBlank()) ? "World" : name;
        return new Greeting(counter.incrementAndGet(), String.format(template, who));
    }
}