package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.costom.exception.BusinessException;
import com.example.demo.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmps();

	public Employee addEmployee(Employee employee) throws BusinessException;

	public  Optional<Employee> getEmployeeById(Long id);

	public void updateEmployee(Employee empFromRequest);

}
 