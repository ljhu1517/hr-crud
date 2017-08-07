package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lydiahu.hrcrud.dao.EmployeeRepository;
import com.lydiahu.hrcrud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return (List<Employee>) this.employeeRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Employee findById(BigDecimal id) {
		return this.employeeRepository.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Employee e) {
		this.employeeRepository.delete(e);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		this.employeeRepository.delete(id);
		
	}

	@Override
	@Transactional
	public Employee saveOrUpdate(Employee e) {
		return this.employeeRepository.save(e);
	}

}
