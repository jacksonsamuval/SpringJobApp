<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	
<title>Jackson Job Portal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .application-list {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .application-item {
            padding: 15px;
            border-bottom: 1px solid #ddd;
        }
        .application-item:last-child {
            border-bottom: none;
        }
        .application-item h2 {
            margin: 0;
            color: #4CAF50;
            font-size: 20px;
        }
        .application-item p {
            margin: 5px 0;
            color: #555;
        }
    </style>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-warning" style="max-height: 126px;">
	       <div class="container">
	           <a class="navbar-brand fs-1 fw-medium" href="#">Jackson Job Portal Web App</a>
	           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	               <span class="navbar-toggler-icon"></span>
	           </button>
	           <div class="collapse navbar-collapse" id="navbarNav">
	               <ul class="navbar-nav ms-auto">
	                   <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
	                   <li class="nav-item"><a class="nav-link" href="viewalljobs">Jobs</a></li>
	                   <li class="nav-item"><a class="nav-link" href="/">Contact</a></li>
	               </ul>
	           </div>
	       </div>
	   </nav>
	
	
    <h1 	   style="
	       margin-top: 20px;
	   ">Application List</h1>
    <div class="application-list">
        <!-- Iterate over the applications list and display each application's data -->
        <c:forEach var="Applied" items="${Applied}">
            <div class="application-item">
                <h2>${Applied.name}</h2>
				<p><strong>Applied Profile:</strong> ${Applied.profile}</p>
                <p><strong>Mother's Name:</strong> ${Applied.motherName}</p>
                <p><strong>Father's Name:</strong> ${Applied.fatherName}</p>
                <p><strong>Age:</strong> ${Applied.age}</p>
                <p><strong>Qualification:</strong> ${Applied.qualification}</p>
                <p><strong>Phone:</strong> ${Applied.phone}</p>
                <p><strong>Email:</strong> ${Applied.email}</p>
                <p><strong>Address:</strong> ${Applied.address}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
