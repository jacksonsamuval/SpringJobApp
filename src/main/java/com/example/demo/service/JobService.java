package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobPost;
import com.example.demo.repository.JobsRepo;

@Service
public class JobService {

	@Autowired
	private JobsRepo repo;
	
	public List<JobPost> retrieveData() {
		
		return repo.findAll();
	}

	public void addData(JobPost jobpost) {
		
		repo.addJobs(jobpost);
	}

}
