package com.thiethaa.employee_docker.controller;

import com.thiethaa.employee_docker.entity.Employee;
import com.thiethaa.employee_docker.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/welcome")
    public Employee sayHello() {
        System.out.println(">>>> Hello from welcome Path request mapping... <<<<");
        return employeeService.getEmployee();
    }

    @GetMapping("/employees")
    public List<Employee> getEmployess() {
        return employeeService.getEmployees();
    }

    @PostMapping("/addEmployee")
    public Employee addEmp(@RequestBody Employee employee) {
        return employeeService.addEmp(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmp(@RequestBody Employee employee, @PathVariable("id") String id) {
        return employeeService.updateEmp(employee, id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmp(@PathVariable("id") String id) {
        employeeService.deleteEmp(id);
    }
}
