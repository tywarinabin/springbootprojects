package spring_core.example.springcoreprogram;

import org.springframework.stereotype.Component;

@Component
public class Finance implements Employee{
    @Override
    public String getEmployeeDetails() {
        return "I am From Finance Department";
    }
}
