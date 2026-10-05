package com.example.Employee_System.controller;

import com.example.Employee_System.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Employee_System.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private  EmployeeService service;


    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        return service.add(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        System.out.println("Getting all employees");
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,
                           @RequestBody Employee employee) {
        return service.update(id, employee);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }

}
