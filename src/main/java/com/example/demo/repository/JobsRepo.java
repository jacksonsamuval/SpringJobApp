package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Applied;
import com.example.demo.model.JobPost;

@Repository
public class JobsRepo {
	
	private JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

//	public List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//			
//			new JobPost(1,"python dev","good boy",5, List.of("python","swift")),
//			new JobPost(2,"java dev","good boy",2, List.of("java","swift"))
//			));
	

	
	public void addJobs(JobPost jobpost) {
		
		String techStack = String.join(",", jobpost.getPostTechStack());
		
		String sql = "insert into jobsavailaible(postId, postProfile, postDesc, reqExperience, postTechStack) values(?,?,?,?,?)";
		int row = jdbc.update(sql,jobpost.getPostId(),jobpost.getPostProfile(),jobpost.getPostDesc(),jobpost.getReqExperience(),techStack);
		System.out.println("row affected :"+row);
	}

	
	
	public List<JobPost> findAll() {
		
		String sql = "select * from jobsavailaible";
		RowMapper<JobPost> mapper = new RowMapper<>()
				{
					@Override
					public JobPost mapRow(ResultSet rs,int rowNum) throws SQLException
					{
						JobPost j = new JobPost();
						j.setPostId(rs.getInt("postId"));
						j.setPostProfile(rs.getString("postProfile"));
						j.setPostDesc(rs.getString("postDesc"));
						j.setReqExperience(rs.getInt("reqExperience"));
						
						String techStack = rs.getString("postTechStack");
			            List<String> techStackList = Arrays.asList(techStack.split(","));
			            j.setPostTechStack(techStackList);
						
						return j;
					}
				};
		return jdbc.query(sql,mapper);
	}
	
	

	public Optional<JobPost> findById(int id) {
		 String sql = "SELECT * FROM jobsavailaible WHERE postId = ?";
	        try {
	            @SuppressWarnings("deprecation")
				JobPost job = jdbc.queryForObject(sql, new Object[]{id}, new RowMapper<JobPost>() {
	                @Override
	                public JobPost mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    JobPost job = new JobPost();
	                    job.setPostId(rs.getInt("postId"));
	                    job.setPostProfile(rs.getString("postProfile"));
	                    job.setPostDesc(rs.getString("postDesc"));
	                    job.setReqExperience(rs.getInt("reqExperience"));

	                    String techStack = rs.getString("postTechStack");
	                    List<String> techStackList = Arrays.asList(techStack.split(","));
	                    job.setPostTechStack(techStackList);

	                    return job;
	                }
	            });
	            return Optional.ofNullable(job);
	        } catch (EmptyResultDataAccessException e) {
	            // Return an empty Optional if no result is found
	            return Optional.empty();
	        } catch (Exception e) {
	            // Handle other potential exceptions
	            throw new RuntimeException("Error retrieving job for id: " + id, e);
	        }   
	}

	
	
	public void addJobsSubmit(Applied applied) {
		
		String sql = "INSERT into jobapplied(name,motherName,fatherName,age,qualification,phone,email,address, profile) values(?,?,?,?,?,?,?,?,?)";
		int rows = jdbc.update(sql,applied.getName(),applied.getMotherName(),applied.getFatherName(),applied.getAge(),applied.getQualification(),applied.getPhone(),applied.getEmail(),applied.getAddress(),applied.getProfile());
		System.out.println("row affected :"+ rows);
		
	}

	
	
	
	public List<Applied> getAppliedData() 
	{
		String sql = "SELECT * from jobapplied";
		RowMapper<Applied> mapper = new RowMapper<>()
				{
					@Override
					public Applied mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Applied a = new Applied();
						a.setName(rs.getString("name"));
						a.setMotherName(rs.getString("motherName"));
						a.setFatherName(rs.getString("fatherName"));
						a.setAge(rs.getInt("age"));
						a.setQualification(rs.getString("qualification"));
						a.setPhone(rs.getString("phone"));
						a.setEmail(rs.getString("email"));
						a.setAddress(rs.getString("address"));
						a.setProfile(rs.getString("profile"));
						
					return a;
					}
					};
		
		
		
		return jdbc.query(sql, mapper);
	}
	       

}
