package com.example.EmployeeSalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private SalaryCalculator salaryCalculator;

    @Autowired
    public Employee(@Qualifier("hourly") SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    public double getSalary() {
        return salaryCalculator.calculateSalary();
    }
}

