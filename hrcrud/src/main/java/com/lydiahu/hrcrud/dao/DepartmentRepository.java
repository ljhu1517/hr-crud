package com.lydiahu.hrcrud.dao;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import com.lydiahu.hrcrud.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, BigDecimal> {

	
}
