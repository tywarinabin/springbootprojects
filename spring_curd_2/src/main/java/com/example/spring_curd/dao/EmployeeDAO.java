package com.example.spring_curd.dao;
import com.example.spring_curd.bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee e);
    Employee findById(Integer empId);
    void delete(Employee e);
    List<Employee> getRecords();
}
