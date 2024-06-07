package com.example.spring_curd.dao;

import com.example.spring_curd.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee e) {
        entityManager.persist(e); // Persist Method for save/retrive information.
    }

    @Override
    public Employee findById(Integer empid) {
        return entityManager.find(Employee.class,empid);
    }

    @Override
    @Transactional
    public void delete(Employee e) {
        entityManager.remove(e);
    }

    @Override
    public List<Employee> getRecords() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> results;
        results = typedQuery.getResultList();
        return results;
    }
}
