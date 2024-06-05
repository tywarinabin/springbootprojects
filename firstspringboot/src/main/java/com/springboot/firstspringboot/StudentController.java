package com.springboot.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/greet")
    public String greet(){
        return "Good Morning from students";
    }
    @GetMapping("")
    public String say(){
        return "Hey you are in the Rest COntroller Class of Student";
    }
    @GetMapping("/request")
    public String request(){
        return "May I go to Toilet Ma'am / Sir ?";
    }
}
