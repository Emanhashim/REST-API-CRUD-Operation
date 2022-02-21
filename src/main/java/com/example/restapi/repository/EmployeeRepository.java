package com.example.restapi.repository;

import com.example.restapi.model.register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<register, Long> {
}
