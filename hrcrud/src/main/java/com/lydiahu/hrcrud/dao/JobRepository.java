package com.lydiahu.hrcrud.dao;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.lydiahu.hrcrud.model.Job;

public interface JobRepository extends CrudRepository<Job, BigDecimal> {

}
