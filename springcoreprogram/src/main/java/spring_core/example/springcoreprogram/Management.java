package spring_core.example.springcoreprogram;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Management implements Employee{
    @Override
    public String getEmployeeDetails() {
        return "I am From Management Department";
    }
}
