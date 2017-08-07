package com.lydiahu.hrcrud.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lydiahu.hrcrud.dto.EmployeeDTO;
import com.lydiahu.hrcrud.model.Department;
import com.lydiahu.hrcrud.model.Employee;
import com.lydiahu.hrcrud.model.Job;
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
	public String load(Model model) {
		
		List<Employee> employees = this.employeeService.findAll();
		List<EmployeeDTO> dtos = new ArrayList<EmployeeDTO>();
		
		for(Employee bean: employees) {
			EmployeeDTO beanDTO =this.getEmployeeDto(bean);
			dtos.add(beanDTO);
		}
		
		model.addAttribute("dtos", dtos);
		
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
		
		Employee e = this.employeeService.findById(id);
		
		model.addAttribute("indvEmpKey", e);
		return null; 
	}
	@RequestMapping("/add-new")
	public String addEmp(Model model) {
		
		List<Department> departments = this.departmentService.findAll();
		List<Job> jobs = this.jobService.findAll();
		
		//model -> business layer data send to UI
		
		model.addAttribute("departments", departments);
		model.addAttribute("jobs", jobs);
		model.addAttribute("managers", this.getManagers());
		
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
		
		return "redirect:/";		//return to home page
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(Model model, @RequestParam BigDecimal id) {
		
		this.employeeService.delete(id);
		
		return "";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployee(Model model, @RequestParam BigDecimal id, @RequestParam String fname, @RequestParam String lname, @RequestParam String email, @RequestParam BigDecimal manager) {
		
		Employee e = this.employeeService.findById(id);
		
		e.setFirstName(fname);
		e.setLastName(lname);
		e.setEmail(email);
		e.setManagerId(manager);
		
		Employee newEmp = this.employeeService.saveOrUpdate(e);
		model.addAttribute(newEmp);		//return result to UI, make data available
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/load-update")
	public String loadUpdatePage(@RequestParam BigDecimal id, Model model) {
		
		Employee e = this.employeeService.findById(id);
		EmployeeDTO dto = this.getEmployeeDto(e);
		
		model.addAttribute("dto", dto);
		model.addAttribute("managers", this.getManagers());
		
		return "edit";
	}
	
	private EmployeeDTO getEmployeeDto(Employee e) {
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setFirstName(e.getFirstName());
		dto.setLastName(e.getLastName());
		dto.setEmail(e.getEmail());
		dto.setEmployeeId(e.getId());
		dto.setDepartmentName(e.getDepartment().getName());
		dto.setManagerName(e.getManagerId()==null?"":this.employeeService.findById(e.getManagerId()).toString());
		dto.setEditUrl("<a href='/update?id=" + dto.getEmployeeId()+ "' "+ "class='btn btn-success'>Update</a>");
		dto.setDeleteUrl("<a href='/delete?id=" + dto.getEmployeeId()+ "' "+ "class='btn btn-warning'>Delete</a>");
		return dto;
	}
	
	private List<EmployeeDTO> getManagers() {
		
		List<Employee> all = this.employeeService.findAll();
		List<Employee> managers0 = all.stream()
				.filter(bean -> (bean.getJob().getId().equals(new BigDecimal(2)) || bean.getJob().getId().equals(new BigDecimal(3))))
				.collect(Collectors.toList());
		
		List<EmployeeDTO> managers = new ArrayList<EmployeeDTO>();
		
		for(Employee emp : managers0) {
			EmployeeDTO bean = new EmployeeDTO();
			bean.setDepartmentName(emp.getDepartment().getName());
			bean.setFirstName(emp.getFirstName());
			bean.setLastName(emp.getLastName());
			bean.setEmail(emp.getEmail());
			bean.setEmployeeId(emp.getId());
			bean.setManagerName(emp.toString());
			managers.add(bean);
		}
		
		return managers;
	}
	
}
