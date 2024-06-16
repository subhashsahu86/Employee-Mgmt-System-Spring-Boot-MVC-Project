package com.subh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subh.model.Employee;
import com.subh.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public List<Employee> fetchAllEmployee() {
       
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
       
		int idValue = empRepo.save(emp).getEmpno();
		
		return "Employee saved with idValue="+idValue; 
		
	}

	@Override
	public Employee getEmployeeByNo(int no) {
        
		//use repository
		Employee emp = empRepo.getReferenceById(no);
		 
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		
		Optional<Employee> opt = empRepo.findById(emp.getEmpno());
		
		if(opt.isPresent()) {
			empRepo.save(emp);
			return emp.getEmpno()+" Employee is Updated";
		}
		return emp.getEmpno()+" Employee is not available for updation";
	}

	@Override
	public String deleteEmployee(int no) {
        empRepo.deleteById(no);
		return " Employee Deleted Successfully";
	}

}
