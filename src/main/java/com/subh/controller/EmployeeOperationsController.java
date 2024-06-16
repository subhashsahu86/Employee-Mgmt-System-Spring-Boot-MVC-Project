package com.subh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.subh.model.Employee;
import com.subh.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHomePage() {

		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {

		List<Employee> empList = empService.fetchAllEmployee();

		map.put("empsInfo", empList);

		return "show_report";
	}

	@GetMapping("/register")
	public String showRegisterEmployeeFormPage(@ModelAttribute("emp") Employee emp) {

		return "employee_register_form";

	}

	/*@PostMapping("/register")
	public String processRegisterEmployeeFormPage(
			@ModelAttribute("emp")Employee emp,Map<String,Object>map) {
		
		//use service class 
		String msg = empService.registerEmployee(emp); //for register a employee
		
		//keep the msg in the model attribute
		map.put("resultMsg", msg);
		
		List<Employee> list = empService.fetchAllEmployee();
		map.put("empsInfo", list);    // to fetch all Employees
		
	    //return LVN
		return "show_report";
		
		note: here there are two problems
		1:code redundancy problem is occurs bcz we write logic again for 
		fetching all employees operations that are already done in /report handler method 
		2: if we refresh the page then duplicate record is save 
		 so we redirect to /report handler method
		 Solution:PRG(Post Redirect Get) pattern
			
		}*/

	/*@PostMapping("/register")  //PRG---->pattern + FlashAttributes
	public String processRegisterEmployeeFormPage(
			@ModelAttribute("emp")Employee emp,RedirectAttributes atribts) {
		
		String msg = empService.registerEmployee(emp);
		
		atribts.addFlashAttribute("resultMsg", msg);
	   
		return "redirect:report";
	
	}*/
	
	@PostMapping("/register")  //PRG---->pattern + SessionAttributes
	public String processRegisterEmployeeFormPage(
			@ModelAttribute("emp")Employee emp,HttpSession ses) {
		
		String msg = empService.registerEmployee(emp);
		
		ses.setAttribute("resultMsg", msg);
	   
		return "redirect:report";
	
	}
	
	@GetMapping("/edit")
	public String showEditFormPage(
			@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		//use service
		Employee emp1 = empService.getEmployeeByNo(no);
		
		//copy emp1 data to ModelAttribute emp object
		
		BeanUtils.copyProperties(emp1, emp);
		
		//return LVN
		
		return "employee_edit_form" ;
	}
	
	@PostMapping("/edit")
	public String procesEditFormPage(
			RedirectAttributes attrbts,@ModelAttribute("emp") Employee emp) {
		//use the service
		String msg = empService.updateEmployee(emp);
		
		attrbts.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployeeByNo(@RequestParam("no") int no, RedirectAttributes attrbts) {
		
		//use service
		
		String msg = empService.deleteEmployee(no);
		

		attrbts.addFlashAttribute("resultMsg", msg);
		
		return "redirect:report";
		
	}
	
	
	
	
	
	
	

}
