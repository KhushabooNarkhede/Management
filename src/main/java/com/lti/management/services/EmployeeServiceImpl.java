package com.lti.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.management.entity.Employee;
import com.lti.management.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> l = empRepo.findAll();
		return l;
	}

	@Override
	public void saveEmployee(Employee e) {

		empRepo.save(e);
	}

	@Override
	public void updateEmployeeDetails(Employee e) {
		
		 Employee currentEmployee = empRepo.findById(e.getEmpId()).orElseThrow(RuntimeException::new);  
		 currentEmployee.setDeptId(e.getDeptId()); 
		 currentEmployee.setDeptName(e.getDeptName());
		 currentEmployee.setEmpName(e.getEmpName());
		 currentEmployee.setMobileNo(e.getMobileNo());
	
		 empRepo.save(currentEmployee);
		  
	}

	@Override
	public void deleteEmployeeDetails(long empId) {
		empRepo.deleteById(empId);
		
	}
	@Override
	public List<Employee> findByempNameOrdeptName(String empName, String deptName) {
		// TODO Auto-generated method stub
		return empRepo.findByempNameOrdeptName(empName, deptName);
	}

}
