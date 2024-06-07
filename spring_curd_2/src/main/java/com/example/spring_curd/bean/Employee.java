package com.example.spring_curd.bean;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // For Unique auto-increment option.
    @Column(name = "empid")
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
    public Employee(){}
    public Employee(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dept='" + dept + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", empId=" + empId +
                '}';
    }
    public String getName(){
        return name;
    }
}
