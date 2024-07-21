package com.restapi.employeedemo.dao;
import com.restapi.employeedemo.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employees> viewAll() {
        TypedQuery<Employees> theEmployee = entityManager.createQuery("from Employees", Employees.class);
        List<Employees> employee = theEmployee.getResultList();
        return employee;
    }

    @Override
    public Employees findById(int empId) {
       Employees dbEmp = entityManager.find(Employees.class,empId);
       if(dbEmp == null){
           throw new RuntimeException("Employee Not Found .");
       }
       return dbEmp;
    }

    @Override
    public Employees save(Employees e) {
        Employees dbEmp = entityManager.merge(e);
        return dbEmp;
    }

    @Override
    public void deleteById(int id) {
        Employees e = findById(id);
        entityManager.remove(e);
    }
}
