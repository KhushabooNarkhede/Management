package com.lti.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.management.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	//@Query(value = "select e from Employee e where e.empName=:empName or e.deptName=:deptName", nativeQuery = true)
	@Query("select e from Employee e where e.empName=:empName OR e.deptName=:deptName")
	
	public List<Employee> findByempNameOrdeptName (@Param("empName") String empName, @Param("deptName") String deptName);
	
}
