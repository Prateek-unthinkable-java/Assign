package com.example.Assign.service;

import com.example.Assign.entity.Employee;
import com.example.Assign.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long empId) {
        Employee employee1= employeeRepository.findById(empId).get();
        employee1.setEmpId(employee.getEmpId());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpDesn(employee.getEmpDesn());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee entity = employeeRepository.getById(id);
        employeeRepository.delete(entity);
    }

    public EmployeeServiceImpl(EmployeeRepository repo){
        this.employeeRepository=repo;
    }
}
