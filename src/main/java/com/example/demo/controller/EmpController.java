package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")

public class EmpController {
	
	@Autowired
	public EmployeeService empService;
	
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmps(){
		
		List<Employee> empList= empService.getAllEmps();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
		
	}
	@PostMapping()
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee requestEmployee){
		Employee employeecreated=empService.addEmployee(requestEmployee);	
		return new ResponseEntity<Employee>(employeecreated, HttpStatus.CREATED);
		
	}
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") long empIdL){
		System.out.println("Employee Id from request "+empIdL);
		 Optional<Employee> employee=empService.getEmployeeById(empIdL);
		 
		return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping()
	public ResponseEntity updateEmployeeId(@RequestBody Employee empFromRequest){
		empService.updateEmployee(empFromRequest);
		return new ResponseEntity(HttpStatus.ACCEPTED);
		
	}

	
}
