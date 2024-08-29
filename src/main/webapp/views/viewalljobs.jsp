<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="ab" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.JobPost" %>
<%@ page import="com.example.demo.repository.JobsRepo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Post List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<body>
	    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
	        <div class="container">
	            <a class="navbar-brand fs-1 fw-medium" href="#">Jackson Job Portal Web App</a>
	            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
	                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	            </button>
	            <div class="collapse navbar-collapse" id="navbarNav">
	                <ul class="navbar-nav ms-auto d-flex align-items-center">
	                    <!-- Search Form -->
	                    <li class="nav-item">
	                        <form class="d-flex navbar-search-form" action="search" method="get">
	                            <input class="form-control me-2" type="search" name="search" placeholder="Search for job posts..." aria-label="Search">
	                            <button class="btn btn-outline-dark" type="submit" style="background-color:black; color:white">Search</button>
	                        </form>
	                    </li>
	                    <!-- Navigation Links -->
	                    <li class="nav-item">
	                        <a class="nav-link" href="/home">Home</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="viewalljobs">All Jobs</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="/">Contact</a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>

	    <!-- Scripts for Bootstrap -->
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<ab:set var="submitForm" value="${JobPost}" />

    <h2 class="mb-4 text-center font-weight-bold" style="margin-top:20px">Job Post List</h2>

    <div class="row row-cols-2"  style="flex-direction: column; align-items: center">
        <ab:forEach var="JobPost" items="${JobPost}">
            <div class="col mb-4">
                <div class="card border-dark bg-dark text-white">
                    <div class="card-body">
                        <h5 class="card-title"></h5>
						<p class="card-text">
							<form action="jobapply/${JobPost.postId}" method="get">
						                           <strong>Job-Id: </strong>
						                          ${JobPost.postId}
						                       </p>
											   <p class="card-text">
											   	<strong>Job-Profile: </strong>
											   	 ${JobPost.postProfile}
											   </p>
						                       <p class="card-text">
						                           <strong>Description:</strong>
												${JobPost.postDesc}
						                       </p>
						                       <p class="card-text">
						                           <strong>Experience Required:</strong>
												${JobPost.reqExperience}
						                       </p>
						                       <p class="card-text">
						                           <strong>Tech Stack Required:</strong>
						                           <ul>
						                               <ab:forEach var="tech" items="${JobPost.postTechStack}">
						                                   <li> ${tech} </li>
						                               </ab:forEach>
						                           </ul>
						                       </p>
											   <button type="submit" class="btn btn-primary">Apply</button>
											   	</form>
                    </div>
                    <div class="card-footer">
                        <!-- Optional footer content -->
                    </div>
                </div>
            </div>
        </ab:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>