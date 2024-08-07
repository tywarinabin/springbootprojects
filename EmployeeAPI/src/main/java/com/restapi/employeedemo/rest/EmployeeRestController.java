package com.restapi.employeedemo.rest;

import com.restapi.employeedemo.entity.Employees;
import com.restapi.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employees> getAll(){
       return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employees getEmp(@PathVariable int empId){
        return employeeService.findById(empId);
    }


    @PostMapping("/employees")
    public Employees save(@RequestBody Employees e){
        e.setId(0);
        return employeeService.save(e);
    }

    @PutMapping("/employees")
    public Employees update(@RequestBody Employees e)
    {
        return employeeService.save(e);
    }


    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        employeeService.deleteById(empId);
        return "Deleted employee of ID: "+empId;
    }

}
