package com.lydiahu.hrcrud.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lydiahu.hrcrud.dao.JobRepository;
import com.lydiahu.hrcrud.model.Job;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	
	@Override
	public List<Job> findAll() {
		return (List<Job>) this.jobRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Job findById(BigDecimal id) {
		
		return this.jobRepository.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Job e) {
		this.jobRepository.delete(e);
	}

	@Override
	@Transactional
	public void delete(BigDecimal id) {
		this.jobRepository.delete(id);
		
	}

	@Override
	@Transactional
	public Job saveOrUpdate(Job e) {
		return this.jobRepository.save(e);
	}

}
