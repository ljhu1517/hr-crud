package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lydiahu.hrcrud.dao.DepartmentRepository;
import com.lydiahu.hrcrud.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Department findOne(BigDecimal id) {
		return this.departmentRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return (List<Department>) this.departmentRepository.findAll();
	}

	@Override
	@Transactional
	public Department saveOrUpdate(Department d) {
		return this.departmentRepository.save(d);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		this.departmentRepository.delete(id);
	}

	@Override
	@Transactional
	public void delete(Department d) {
		this.departmentRepository.delete(d);
	}

}
