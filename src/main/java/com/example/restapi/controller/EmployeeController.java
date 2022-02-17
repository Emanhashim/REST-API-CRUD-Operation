package com.example.restapi.controller;

import com.example.restapi.model.Employee;
import com.example.restapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

//    this injects service constructor
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
//    build and create rest api to create employee, insert employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

//    builds to get all employees restapi, fetch employee
    @GetMapping()
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
    }

//    get all employee by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid){
return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid), HttpStatus.OK);
    }

//this for update employee
    @PutMapping("{id}")
//this uses to update the id, as http:localhost:8080/api/employee/1, kind of form
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                    @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

//    this for delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
//        this deletes the employee from db
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("you have delete it sucessfully", HttpStatus.OK);
    }





}