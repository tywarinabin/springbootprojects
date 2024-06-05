package com.example.spring_curd.bean;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // For Unique auto-increment option.
    private int empId;

    @Column
    private String name;

    @Column
    private String dept;
    @Column
    private String location;

    public Employee(String name, String dept, String location) {
        this.name = name;
        this.dept = dept;
        this.location = location;
    }
    public int getEmpId(){
        return empId;
    }
}
