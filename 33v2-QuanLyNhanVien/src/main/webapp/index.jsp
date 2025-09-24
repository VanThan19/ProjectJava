<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.NhanVienDAO"%>
<%@page import="com.entity.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_csss.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<p class="text-center fs-1">ALL Nhan Vien</p>
				<c:if test="${not empty capnhat }">
					<p class="text-center text-success">${capnhat }</p>
					<c:remove var="capnhat" />
				</c:if>

				<c:if test="${not empty khong}">
					<p class="text-center text-success">${khong }</p>
					<c:remove var="khong" />
				</c:if>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">FULL NAME</th>
							<th scope="col">Date Of Birth</th>
							<th scope="col">ADDRESS</th>
							<th scope="col">CHUC VU</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					
					<%
					
					NhanVienDAO dao = new NhanVienDAO(DBConnect.getCon());
					List<NhanVien> list = dao.getAllNhanVien();
					for(NhanVien nv : list) { %>
						<tr>
					
						<th scope ="row"><%= nv.getName() %></th>
						<td><%= nv.getDob() %></td>
						<td><%= nv.getAdr() %></td>
						<td><%= nv.getChucvu() %></td>
						<td><a href="edit_nhanvien.jsp?id=<%=nv.getId()%>" class="btn btn-sm btn-primary">Edit</a>
						<a href="delete?id=<%=nv.getId()%>" class = "btn btn-sm btn-danger ms-1">Delete</a>
						</td>
						</tr>
						
						
					<% 
					}
					
					%>

					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>