package com.example.Assign.controller;

import com.example.Assign.entity.Department;
import com.example.Assign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/{deptId}")
    public Department getDepartment(@PathVariable Long deptId){
        return departmentService.getDepartment(deptId);
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @PutMapping("/")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable String deptId){
        try{
            departmentService.deleteDepartment(Long.parseLong(deptId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
