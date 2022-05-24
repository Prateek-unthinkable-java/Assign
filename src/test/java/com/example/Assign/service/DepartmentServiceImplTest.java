package com.example.Assign.service;

import com.example.Assign.entity.Department;
import com.example.Assign.repository.DepartmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    Department department=new Department(1l,"Java developer");

    @Mock
    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        this.departmentService= new DepartmentServiceImpl(this.departmentRepository);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDepartments() {
        departmentService.getDepartments();
        verify(departmentRepository).findAll();
    }

    @Disabled
    void getDepartment() {
        departmentService.getDepartment(1l);
        Department d = departmentRepository.getById(1l);
        verify(departmentRepository).getById(d.getDeptId());
    }

    @Test
    void addDepartment() {
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        assertThat(departmentService.addDepartment(department)).isEqualTo(department);
    }

    @Test
    void updateDepartment() {
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        assertThat(departmentService.updateDepartment(department)).isEqualTo(department);
    }

    @Test
    void deleteDepartment() {
        departmentService.deleteDepartment(1l);
        Department dept = departmentRepository.getById(1l);
        verify(departmentRepository).delete(dept);
    }
}