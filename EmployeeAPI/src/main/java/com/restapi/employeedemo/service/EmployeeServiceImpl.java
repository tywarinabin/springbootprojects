package com.restapi.employeedemo.service;

import com.restapi.employeedemo.dao.EmployeeDAO;
import com.restapi.employeedemo.entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employees> findAll() {
        return employeeDAO.viewAll();
    }
    @Override
    public Employees findById(int id){
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employees save(Employees e) {
        // Set id of employee to 0 for addition of new data to the database
        Employees emp = employeeDAO.save(e);
        return emp;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
