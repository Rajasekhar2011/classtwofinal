package com.devops.classTwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassTwoController {

    @GetMapping("/greetings/{name}")
    public String greetings(@PathVariable String name){
        return "Hello "+name+" Congratulations you have successfully completed Jenkins CI/CD demo";
    }
}
