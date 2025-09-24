<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body"></div>
					<p class="fs-3 text-center">Add Student</p>

                         <c:if test="${not empty VanThan }">
                         <p class="text-center text-success">${VanThan }</p>
                         <c:remove var="VanThan"/>
                         
                         </c:if>
                         
                          <c:if test="${not empty ErrorVanThan }">
                         <p class="text-center text-success">${ErrorVanThan }</p>
                         <c:remove var="ErrorVanThan"/>
                         
                         </c:if>


					<form action="resgister" method="post">
						<div class="mb-3">
							<label class="form-label">FUll NAME</label> <input type="text"
								name="name" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Date Of Birth</label> <input name="dob"
								type="date" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Address</label> <input type="text"
								name="addr" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Qualification</label> <input
								name="qualification" type="text" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Email</label> <input type="email"
								name="email" class="form-control">
						</div>

						<button type="submit" class="btn btn-primary col-md-12">Submit</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>