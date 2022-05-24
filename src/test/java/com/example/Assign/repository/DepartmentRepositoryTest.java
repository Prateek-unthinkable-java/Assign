package com.example.Assign.repository;

import com.example.Assign.entity.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void isDepartmentExitsById() {
        Department department=new Department(1L,"IT");
        departmentRepository.save(department);
        Boolean actual=departmentRepository.isDepartmentExitsById(1L);
        assertThat(actual).isTrue();
    }
}