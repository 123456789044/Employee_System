package com.example.Employee_System.service;

import com.example.Employee_System.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Employee_System.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee add(Employee employee) {
        return repository.save(employee);
    }
    public List<Employee> getAll() {
        return repository.findAll();
    }
    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Employee update(Long id, Employee employee) {
        Employee existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setDepartment(employee.getDepartment());
            existing.setAge(employee.getAge());
            existing.setSalary(employee.getSalary());

            return repository.save(existing);
        }
        return null;
    }
}
