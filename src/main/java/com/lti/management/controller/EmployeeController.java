package com.lti.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.management.entity.Employee;
import com.lti.management.services.EmployeeService;

@RestController
@RequestMapping("/api/management")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public List<Employee> listAllEmployee(){
		
		List<Employee> listemp = empService.getAllEmployee();
		return listemp;
	}
	
	@PostMapping("/employee")
	public void storeEmployeeDetails(@RequestBody Employee ee){
		
		empService.saveEmployee(ee);
	}
	
	@PutMapping("/employee")
	public void renewEmployeeDetails(@RequestBody Employee e1) {
		
		empService.updateEmployeeDetails(e1);
	}
	
	@DeleteMapping("/employee/{id}")
	public void destroyEmployeeDetails(@PathVariable("id") long Id) {
		
		empService.deleteEmployeeDetails(Id);
	}
	
	@GetMapping("/employee/findEmpByNameOrDept/{empName}/{deptName}")
	public List<Employee> searchByNameOrDepartment(@PathVariable("empName") String empName, @PathVariable("deptName") String deptName){
		 
		List<Employee> le = empService.findByempNameOrdeptName(empName, deptName);
		return le;
		
	}

}
