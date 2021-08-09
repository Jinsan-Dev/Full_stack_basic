package com.js_example.Full_stack_basic.service;

import com.js_example.Full_stack_basic.exception.UserNotFoundException;
import com.js_example.Full_stack_basic.model.Employee;
import com.js_example.Full_stack_basic.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service                                                        // 비즈니스 로직을 수행하는 class 라는 것을 나타냄
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired                                                  // 스프링이 자동으로 Bean 값을 할당
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id: "+id+" was not found!"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
