package com.example.amigoscode.backendamigoscode.repo;

import com.example.amigoscode.backendamigoscode.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long idEmployee);

    Optional<Employee> findEmployeeById(Long idEmployee);
}
