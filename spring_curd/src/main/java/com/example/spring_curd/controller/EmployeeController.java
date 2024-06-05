package com.example.spring_curd.controller;

import com.example.spring_curd.bean.Employee;
import com.example.spring_curd.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    public EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    // By Default it will automatically insert record when we open home page.
    @RequestMapping("/")
    public String saveRecord(){
        Employee employee = new Employee("Rohit Paudel","Sports ","NY City");
        employeeDAO.save(employee);
        return "Record inserted successfully of Employee ID : "+ employee.getEmpId();
    }
}
