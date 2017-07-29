package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import com.lydiahu.hrcrud.model.Department;

public interface DepartmentService {

	Department findOne(BigDecimal id);
	List<Department> findAll();
	Department saveOrUpdate(Department d);
	void delete(BigDecimal id);
	void delete(Department d);
}
