package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JobPost {
	
	private int postId;
	private String postProfile;
	private String postDesc;
	private int reqExperience;
	private List<String> postTechStack;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostProfile() {
		return postProfile;
	}
	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	public int getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(int reqExperience) {
		this.reqExperience = reqExperience;
	}
	public List<String> getPostTechStack() {
		return postTechStack;
	}
	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}
	@Override
	public String toString() {
		return "JobPost [postId=" + postId + ", postProfile=" + postProfile + ", postDesc=" + postDesc
				+ ", reqExperience=" + reqExperience + ", postTechStack=" + postTechStack + "]";
	}
	
	
	
	public JobPost(int postId, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}
	
	public JobPost()
	{
		System.out.println("in job add method");
	}

}
