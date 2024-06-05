package com.springboot.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/say")
public String sayHello(){
    
    return "Hello From SpringBoot Application  : Saying Hello ";
}
    @GetMapping("/bye")
    public String sayGoodBye(){

        return "GoodBye From SpringBoot Application  : Saying Bye ";
    }

@GetMapping("/")
public String welcome(){
        return "welcome to our spring website";
}
}
