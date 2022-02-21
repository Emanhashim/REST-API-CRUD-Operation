package com.example.restapi.service.impl;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.register;
import com.example.restapi.repository.EmployeeRepository;
import com.example.restapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//dependency injection of repository by using repo constructor
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }


//    here we implement the interface to save all method on interface
    @Override
    public register saveEmployee(register employee) {
        return employeeRepository.save(employee);
    }
//this implements the show all employees method on interface
    @Override
    public List<register> getAllEmployees() {
        return employeeRepository.findAll();
    }
//this impplements the show all employees by id
    @Override
    public register getEmployeeById(Long id) {
        Optional<register> employee = employeeRepository.findById(id);

//        if(employee.isPresent()){
//        return employee.get();
//        }else{
//           throw new ResourceNotFoundException("Employee", "Id", "id");
//        }
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", "id"));

    }
//this for update implement
    @Override
    public register updateEmployee(register employee, long id) {
//  first we gotta check whether employee with this id exists in db or not
        register existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setBirth(employee.getBirth());
      existingEmployee.setCountry(employee.getCountry());
      existingEmployee.setEmail(employee.getEmail());
      existingEmployee.setFirst_name(employee.getFirst_name());
      existingEmployee.setLast_name(employee.getLast_name());
      existingEmployee.setPhone(employee.getPhone());
      existingEmployee.setPassword(employee.getPassword());
      existingEmployee.setRe_password(employee.getRe_password());


//        this save the existing employee to db
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
//this for delete employee implement
//    http://localhost:8080/api/employees/3 or delete by id then delete
    @Override
    public void deleteEmployee(long id) {

//        this checks if the id exist before delete it
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Employee", "Id",id));

        employeeRepository.deleteById(id);


    }


}
