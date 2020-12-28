package com.bharat.dao;

import com.bharat.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee getEmployeeById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
