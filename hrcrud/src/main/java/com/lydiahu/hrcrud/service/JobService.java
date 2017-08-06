package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import com.lydiahu.hrcrud.model.Job;

public interface JobService {

	List<Job> findAll();
	Job findById(BigDecimal id);
	void delete(Job e);
	void delete(BigDecimal id);
	Job saveOrUpdate(Job e);
	
}
