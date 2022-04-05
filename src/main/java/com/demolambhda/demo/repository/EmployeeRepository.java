package com.demolambhda.demo.repository;

import java.util.List;

import com.demolambhda.demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>  {

    public Employee findByempId(Long id); 
}
