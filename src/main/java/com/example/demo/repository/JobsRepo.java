package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
		
		String sql = "insert into jobapp(postId, postProfile, postDesc, reqExperience, postTechStack) values(?,?,?,?,?)";
		int row = jdbc.update(sql,jobpost.getPostId(),jobpost.getPostProfile(),jobpost.getPostDesc(),jobpost.getReqExperience(),techStack);
		System.out.println("row affected :"+row);
	}

	public List<JobPost> findAll() {
		
		String sql = "select * from jobapp";
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
	
	

}
