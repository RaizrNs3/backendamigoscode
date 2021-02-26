package com.example.amigoscode.backendamigoscode.service;

import com.example.amigoscode.backendamigoscode.exception.UserNotFoundException;
import com.example.amigoscode.backendamigoscode.model.Employee;
import com.example.amigoscode.backendamigoscode.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long idEmployee){
        return employeeRepo.findEmployeeById(idEmployee)
                .orElseThrow(() -> new UserNotFoundException("El usuario con el id: " + idEmployee  + " no fue encontrado."));
    }

    public void deleteEmployee(Long idEmployee){
        employeeRepo.deleteEmployeeById(idEmployee);
    }
}
