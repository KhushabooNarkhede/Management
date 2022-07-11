package com.lti.management.services;

import java.util.List;

import com.lti.management.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findByempNameOrdeptName(String empName, String deptName);
	
	public List<Employee> getAllEmployee();
	
	public void saveEmployee(Employee e);
	
	public void updateEmployeeDetails(Employee e);
	
	public void deleteEmployeeDetails(long empId);

}
