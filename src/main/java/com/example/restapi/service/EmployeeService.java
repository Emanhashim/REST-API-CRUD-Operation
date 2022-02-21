package com.example.restapi.service;

import com.example.restapi.model.register;

import java.util.List;

public interface EmployeeService {
//    this method to get the employee data n save method
    register saveEmployee (register employee);

//    this method to show the list of employees in a database
    List<register> getAllEmployees();
//    this method shows the eployee list by id
    register getEmployeeById(Long id);
//    this for update employee
    register updateEmployee(register employee, long id);
//    this for delete employee
    void deleteEmployee(long id);

}
