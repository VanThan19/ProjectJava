<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_csss.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

<!-- Dùng Bootstrap để căn giữa form trong trang -->
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body"></div>
					<p class="fs-3 text-center">Add Student</p>

<!-- Hiển thị thông báo thành công -->	
<!-- test="${not empty bu}" → kiểm tra xem trong scope (request, session) có tồn tại biến bu không.
Nếu có: hiển thị đoạn <p> với nội dung ${bu} (chính là giá trị bạn set trong servlet -->	
			
					<c:if test="${not empty bu }">
                         <p class="text-center text-success">${bu }</p>
                         <c:remove var="bu"/>
                         
                         </c:if>
                         
                          <c:if test="${not empty vcl}">
                         <p class="text-center text-success">${vcl }</p>
                         <c:remove var="vcl"/>
                         
                         </c:if>
					
	<form action="addNhanVien" method="post">
		<div class="mb-3">
			<label class="form-label"> FULL NAME</label> <input type="text"
				name="name" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Date Of Birth</label> <input type="date"
				name="dob" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Address</label> <input type="text"
				name="adr" class="form-control">
		</div>

		<div class="mb-3">
			<label class="form-label">Chuc Vu</label> <input type="text"
				name="chucvu" class="form-control">
		</div>

		<button type="submit" class="btn btn-primary col -md-12">Submit</button>

	</form>

</body>
</html>