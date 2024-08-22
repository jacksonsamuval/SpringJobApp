package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.JobPost;
import com.example.demo.service.JobService;

@Controller
public class HomeController {
	
	@Autowired
	private JobService service;
	
	@GetMapping({"/","home"})
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
	
	@GetMapping("viewalljobs")
	public String findAll(Model m)
	{
		List<JobPost> jobpost = service.retrieveData();
		m.addAttribute("JobPost", jobpost);
		return "viewalljobs";
	}
	
}
