package com.restapi.employeedemo.dao;

import com.restapi.employeedemo.entity.Employees;
import java.util.List;

public interface EmployeeDAO {
    List<Employees> viewAll();
    Employees findById(int empID);
    Employees save(Employees e);
    void deleteById(int id);
}
