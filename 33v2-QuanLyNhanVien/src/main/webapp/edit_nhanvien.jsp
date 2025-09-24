<%@page import="com.entity.NhanVien"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.NhanVienDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_csss.jsp"%>
</head>
<body class ="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body"></div>
					<p class="fs-3 text-center">Edit NhanVien</p>
					
					
					
					<%
					int id = Integer.parseInt (request.getParameter("id"));
					NhanVienDAO dao = new NhanVienDAO(DBConnect.getCon());
					NhanVien s = dao.getNhanVienById(id);
					
					%>
					
					

					<form action ="update" , method ="post">
						<div class="mb-3">
							<label class="form-label">FUll NAME</label> <input type="text" value = "<%= s.getName() %>" name = "name"
								class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Date Of Birth</label> <input name = "dob" value = "<%= s.getDob() %>"
								type="date" class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Address</label> <input type="text" name = "adr" value = "<%= s.getAdr() %>"
								class="form-control">
						</div>

						<div class="mb-3">
							<label class="form-label">Chuc Vu</label> <input name = "chucvu" value = "<%= s.getChucvu() %>"
								type="text" class="form-control">
						</div>
	
						<input type="hidden" name ="id" value = "<%= s.getId()%>">

						<button type="submit" class="btn btn-primary col-md-12">Update</button>
					</form>

				</div>
			</div>
		</div>
	</div>

</body>
</html>