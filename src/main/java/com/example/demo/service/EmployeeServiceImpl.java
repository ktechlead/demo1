/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpDao;

/**
 * @author vempa
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmpDao empDao;

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		System.out.println("List of Employees in service are"+empDao.findAll());
		return empDao.findAll();
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.save(employee);
		
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}

	@Override
	public void updateEmployee(Employee empFromRequest) {
		// TODO Auto-generated method stub
		Optional<Employee> empOptional=empDao.findById(empFromRequest.getEmpId());
		if(empOptional.isPresent()) {
		Employee empFromDB =empOptional.get();
		empFromDB.setEmpName(empFromRequest.getEmpName());
		empDao.save(empFromDB);
		}
		
	}

	
}
