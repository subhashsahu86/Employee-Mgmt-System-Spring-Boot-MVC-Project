package com.subh.service;

import java.util.List;

import com.subh.model.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> fetchAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int no);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int no);
	
	
		
	

}
