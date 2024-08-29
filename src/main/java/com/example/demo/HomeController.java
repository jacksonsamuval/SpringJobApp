package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Applied;
import com.example.demo.model.JobPost;
import com.example.demo.service.JobService;

@Controller
public class HomeController {
	
	@Autowired
	private JobService service;
	
	@GetMapping({"/","home","jobapply/home"})
	public String home()
	{
		return "home";
	}
	
	@GetMapping("addjob")
	public String addJob()
	{
		return "addjob";
	}
	
	@PostMapping("handleForm")
	public String addData(@ModelAttribute JobPost jobpost,Model model)
	{
		model.addAttribute("Jobpost",jobpost);
		service.addData(jobpost);
		return "success";
	}
	
	@GetMapping({"/viewalljobs","/viewall/"})
	public String findAll(Model m)
	{
		List<JobPost> jobpost = service.retrieveData();
		m.addAttribute("JobPost", jobpost);
		return "viewalljobs";
	}
	
	
	@GetMapping("/jobapply/{id}")
	public String apply(@PathVariable("id") int id,Model model) throws Exception
	{
		JobPost job= service.getJobById(id);
		model.addAttribute("Jobpost", job);
		return "jobapply";
	}
	
	@PostMapping("submitForm")
	public String submit(@ModelAttribute Applied applied, Model model)
	{
		service.addDataSubmission(applied);
		model.addAttribute("applied", applied);
		return "successfullapplied";
	}
	
	@GetMapping("viewappliedjobs")
	public String viewApplied(Model m)
	{
		List<Applied> applied= service.getAppliedJob();
		applied.forEach(System.out::println);
		m.addAttribute("Applied", applied);
		return "appliedview";
	}
}
