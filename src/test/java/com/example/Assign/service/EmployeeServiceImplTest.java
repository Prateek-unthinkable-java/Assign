package com.example.Assign.service;

import com.example.Assign.repository.EmployeeRepository;
import com.google.common.base.Verify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        this.employeeService= new EmployeeServiceImpl(this.employeeRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmployees() {
        employeeService.getEmployees();
        verify(employeeRepository).findAll();
    }
}