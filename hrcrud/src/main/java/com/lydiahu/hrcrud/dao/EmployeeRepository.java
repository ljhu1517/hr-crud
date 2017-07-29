package com.lydiahu.hrcrud.dao;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.lydiahu.hrcrud.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, BigDecimal> {

}
