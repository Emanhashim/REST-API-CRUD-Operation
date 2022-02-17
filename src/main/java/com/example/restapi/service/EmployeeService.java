package com.example.restapi.service;

import com.example.restapi.model.Employee;

import java.util.List;

public interface EmployeeService {
//    this method to get the employee data n save method
    Employee saveEmployee (Employee employee);

//    this method to show the list of employees in a database
    List<Employee> getAllEmployees();
//    this method shows the eployee list by id
    Employee getEmployeeById(Long id);
//    this for update employee
    Employee updateEmployee(Employee employee, long id);
//    this for delete employee
    void deleteEmployee(long id);

}
