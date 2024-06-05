package com.example.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SalaryService {
    private SalaryCalculator salaryCalculator;

    @Autowired
    public SalaryService(SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    public double calculateSalary() {
        return salaryCalculator.calculateSalary();
    }
}

