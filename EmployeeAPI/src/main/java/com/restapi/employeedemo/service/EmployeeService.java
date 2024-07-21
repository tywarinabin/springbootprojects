package com.restapi.employeedemo.service;
import com.restapi.employeedemo.entity.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees findById(int id);
    Employees save(Employees e);
    Employees update(Employees e);
    void deleteById(int id);
}
