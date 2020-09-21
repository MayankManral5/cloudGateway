package com.example.firstService.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
public class FirstServiceController {

    @GetMapping("/message")
    public String test(HttpServletRequest httpServletRequest) {
        System.out.println(" header -> " + httpServletRequest.getHeader("Authorization"));
        return "Hello from First Service";
    }

}
