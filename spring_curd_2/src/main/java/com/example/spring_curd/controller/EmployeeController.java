package com.example.spring_curd.controller;

import com.example.spring_curd.bean.Employee;
import com.example.spring_curd.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        Employee employee = new Employee("Kamal Singh","HR","Wellington");
        employeeDAO.save(employee);
        return "Record inserted successfully of Employee ID : "+ employee.getEmpId();
    }
    @RequestMapping("/records")
    public  String getRecords(){
        List<Employee> list = employeeDAO.getRecords();
        return list.toString();
    }
    @RequestMapping("/find")
    public String findByID(){
        Employee e = employeeDAO.findById(3);
        return " " + e;
    }
    @RequestMapping("/delete")
    public String delete(){
        Employee emp = employeeDAO.findById(7);
        String name = emp.getName();
        employeeDAO.delete(emp);
        return "Record Deleted successfully of Employee : " + name;
    }
}
