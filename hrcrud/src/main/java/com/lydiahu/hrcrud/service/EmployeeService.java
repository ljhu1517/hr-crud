package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import com.lydiahu.hrcrud.model.Department;
import com.lydiahu.hrcrud.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(BigDecimal id);
	void delete(Employee e);
	void delete(BigDecimal id);
	Employee saveOrUpdate(Employee e);
}
