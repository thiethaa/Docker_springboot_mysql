package com.thiethaa.employee_docker.service;

import com.thiethaa.employee_docker.entity.Employee;
import com.thiethaa.employee_docker.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmp(Employee employee) {
        Employee emp = new Employee();
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        employeeRepository.save(emp);
        return emp;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setName("Test hard coded employee");
        employee.setSalary(500);

        return employee;
    }

    public Employee updateEmp(Employee newEmp, String id) {
        Optional<Employee> exist = employeeRepository.findById(id);
        Employee emp = new Employee();
        if (exist.isPresent()) {
            emp = exist.get();
            emp.setId(newEmp.getId());
            emp.setName(newEmp.getName());
            emp.setSalary(newEmp.getSalary());
            employeeRepository.save(emp);
        }
        return emp;
    }

    public void deleteEmp(String id) {
        employeeRepository.deleteById(id);
    }

}
