package com.lydiahu.hrcrud.web;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lydiahu.hrcrud.model.Department;
import com.lydiahu.hrcrud.model.Employee;
import com.lydiahu.hrcrud.service.DepartmentService;
import com.lydiahu.hrcrud.service.EmployeeService;
import com.lydiahu.hrcrud.service.JobService;

@Controller
public class HrController {

	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private JobService jobService;
	
	public void login() {
		
	}
	
	@RequestMapping(value = "/")
	public String load() {
		
		return "index";
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
	@RequestMapping("/add-new")
	public String addEmp() {
		return "add-new";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewEmployee(Model model, @RequestParam String fname, @RequestParam String lname, @RequestParam String email, 
			@RequestParam Date hiredate, @RequestParam(required = false) BigDecimal managerid, @RequestParam BigDecimal departmentid, 
			@RequestParam BigDecimal jobid, @RequestParam BigDecimal salary) {
		Department dept = this.departmentService.findOne(departmentid);
		Employee e = new Employee();
		
		e.setFirstName(fname);
		e.setLastName(lname);
		e.setEmail(email);
		e.setHireDate(hiredate);
		e.setDepartment(dept);
		e.setJob(this.jobService.findById(jobid));
		e.setSalary(salary);
		 
		
		this.employeeService.saveOrUpdate(e);
		
		return "index";		//return to home page
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
