package com.demolambhda.demo.service;

import java.util.List;

import com.demolambhda.demo.model.Employee;
import com.demolambhda.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
             }
    
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    } 

    public Employee findEmployee(Long id) {
        return employeeRepository
        .findByempId(id);
        
                
    }

    public Employee findByEmployee(Long id) throws Exception { 
        return employeeRepository
            .findById(id)
            .orElseThrow(()-> new Exception("No Data Found "+ id ));
    }    
}
