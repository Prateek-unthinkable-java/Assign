package com.example.Assign.service;

import com.example.Assign.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getDepartments();

    public Department getDepartment(long id);

    public Department addDepartment(Department department);

    public Department updateDepartment(Department department);

    public void deleteDepartment(long id);
}
