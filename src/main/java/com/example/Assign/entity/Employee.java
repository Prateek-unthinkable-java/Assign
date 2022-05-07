package com.example.Assign.entity;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String empName;
    private String empDesn;

    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    public Employee(){}

    public Employee(Long empId, String empName, String empDesn, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empDesn = empDesn;
        this.department = department;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesn() {
        return empDesn;
    }

    public void setEmpDesn(String empDesn) {
        this.empDesn = empDesn;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDesn='" + empDesn + '\'' +
                ", department=" + department +
                '}';
    }
}
