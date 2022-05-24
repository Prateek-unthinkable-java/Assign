package com.example.Assign.service;

import com.example.Assign.entity.Department;
import com.example.Assign.entity.Employee;
import com.example.Assign.repository.EmployeeRepository;
import com.google.common.base.Verify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    Employee employee = new Employee(1l,"Ravi","Java Developer");
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

    @Disabled
    void getEmployee(){
        employeeService.getEmployee(1l);
        verify(employeeRepository).getById(1l);
    }

    @Test
    void addEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.addEmployee(employee)).isEqualTo(employee);
    }

    @Disabled
    void updateEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.updateEmployee(employee,1l)).isEqualTo(employee);
    }

    @Test
    void deleteEmployee() {
        employeeService.deleteEmployee(1l);
        Employee emp = employeeRepository.getById(1l);
        verify(employeeRepository).delete(emp);
    }
}