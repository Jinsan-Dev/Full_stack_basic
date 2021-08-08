package com.js_example.Full_stack_basic.repo;

import com.js_example.Full_stack_basic.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);   // Long is "id" in Employee

    Optional findEmployeeById(Long id); // 클래스 이름을 인식해서 알아서 해줌
}
