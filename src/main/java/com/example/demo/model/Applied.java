package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Applied {

//	private int submitId;
	private String name;
	private String motherName;
	private String fatherName;
	private int age;
	private String qualification;
	private String phone;
	private String email;
	private String address;
	private String profile;
	
	
	public Applied(String name, String motherName, String fatherName, int age, String qualification, String phone,
			String email, String address, String profile) {
		super();
		this.name = name;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.age = age;
		this.qualification = qualification;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.profile = profile;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Applied [name=" + name + ", motherName=" + motherName + ", fatherName=" + fatherName + ", age=" + age
				+ ", qualification=" + qualification + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", profile=" + profile + "]";
	}
	public Applied()
	{
		System.out.println("in applied contructor");
	}
	
	
	
	
	
}
