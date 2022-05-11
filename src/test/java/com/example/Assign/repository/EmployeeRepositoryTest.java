package com.example.Assign.repository;

import com.example.Assign.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void isEmployeeExitsById() {
        Employee employee=new Employee(1L, "Ravi", "Java Developer");
        employeeRepository.save(employee);
        boolean actual=employeeRepository.isEmployeeExitsById(1L);
        assertThat(actual).isTrue();
    }
}