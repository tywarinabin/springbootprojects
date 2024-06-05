package com.example.EmployeeSalary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("hourly")
public class HourlySalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary() {
        // Example hourly salary calculation
        double hourlyRate = 200.0;
        int hoursWorked = 160;
        return hourlyRate * hoursWorked;
    }
}

