package com.example.EmployeeSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    private Employee fixedSalaryEmployee;
    private Employee hourlySalaryEmployee;

    @Autowired
    public SalaryController(@Qualifier("fixedSalaryCalculator") SalaryCalculator fixedSalaryCalculator,
                            @Qualifier("hourlySalaryCalculator") SalaryCalculator hourlySalaryCalculator) {
        this.fixedSalaryEmployee = new Employee(fixedSalaryCalculator);
        this.hourlySalaryEmployee = new Employee(hourlySalaryCalculator);
    }

    @GetMapping("/salary/fixed")
    public SalaryDetails getFixedSalaryEmployeeSalary() {
        double salary = fixedSalaryEmployee.getSalary();
        String employeeType = "Fixed";
        // Additional data you want to include
        // For example: String employeeName = fixedSalaryEmployee.getName();
        // For simplicity, let's assume all employees have the same name in this example
        String employeeName = "Jurgen Kloppo";

        return new SalaryDetails(employeeName, employeeType, salary);
    }

    @GetMapping("/salary/hourly")
    public SalaryDetails getHourlySalaryEmployeeSalary() {
        double salary = hourlySalaryEmployee.getSalary();
        String employeeType = "Hourly";
        String employeeName = "Joe Gomez";

        return new SalaryDetails(employeeName, employeeType, salary);
    }

    class SalaryDetails {
        private String employeeName;
        private String employeeType;
        private double salary;

        public SalaryDetails(String employeeName, String employeeType, double salary) {
            this.employeeName = employeeName;
            this.employeeType = employeeType;
            this.salary = salary;
        }

        // Getters and setters
        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeType() {
            return employeeType;
        }

        public void setEmployeeType(String employeeType) {
            this.employeeType = employeeType;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "SalaryDetails{" +
                    "Name='" + employeeName + '\'' +
                    ", employeeType='" + employeeType + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}

