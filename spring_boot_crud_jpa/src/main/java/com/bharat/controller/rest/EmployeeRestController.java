package com.bharat.controller.rest;

import com.bharat.entity.Employee;
import com.bharat.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController() {
    }

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getSingleEmployee(@PathVariable int id) {
        Employee employee =  employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("No employee found!!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public void addNewEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee employee =  employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("No employee found with this id!!");
        }
        employeeService.deleteById(id);
    }
}
