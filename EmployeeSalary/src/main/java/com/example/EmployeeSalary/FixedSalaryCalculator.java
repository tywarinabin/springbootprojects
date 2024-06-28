package com.example.EmployeeSalary;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class FixedSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary() {
        // Example fixed salary calculation
        return 25000.0;
    }
}
