package com.example.secondService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondServiceController {

    @GetMapping("/message")
    public String test() {
        return "Hello from in Second Service";
    }
}
