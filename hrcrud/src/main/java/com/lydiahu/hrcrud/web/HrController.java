package com.lydiahu.hrcrud.web;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lydiahu.hrcrud.model.Employee;
import com.lydiahu.hrcrud.service.DepartmentService;
import com.lydiahu.hrcrud.service.EmployeeService;

@Controller
public class HrController {

	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private DepartmentService departmentService;
	
	
	public void login() {
		
	}
	
	@RequestMapping(value = "/getAll")
	public String getAllEmployees(Model model) {
		
		List<Employee> employees = this.employeeService.findAll();
		
		//put data in model
		model.addAttribute("employeeKey", employees);
		return null;
	}
	
	@RequestMapping(value = "/getOne/{id}")
	public String getEmployeeById(Model model, @PathVariable("id") BigDecimal id) {
		
		Employee e = this.employeeService.findByID(id);
		
		model.addAttribute("indvEmpKey", e);
		return null; 
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewEmployee(Model model, @RequestParam BigDecimal id) {
				
		return "";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteEmployee(Model model, @RequestParam BigDecimal id) {
		
		this.employeeService.delete(id);
		
		return "";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(Model model, @RequestParam BigDecimal id, @RequestParam String lastName, @RequestParam BigDecimal salary) {
		
		Employee e = this.employeeService.findByID(id);
		
		e.setFirstName(lastName);
		e.setSalary(salary);
		
		Employee newEmp = this.employeeService.saveOrUpdate(e);
		model.addAttribute(newEmp);		//return result to UI, make data available
		
		return null;
	}
	
}
