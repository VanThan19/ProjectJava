package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/resgister")

public class ResgisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String addr = req.getParameter("addr");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		
		Student student = new Student(name,dob,addr,qualification,email);
		
		StudentDAO dao = new StudentDAO(DBConnect.getConn());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addStudent(student);
		
		if (f) {
			session.setAttribute("VanThan", "Submit thanh cong");
			resp.sendRedirect("add_student.jsp");
//			System.out.println("Student Details submit thanh cong...");
		}else {
			session.setAttribute("ErrorVanThan", "Submit un thanh cong");
			resp.sendRedirect("add_student.jsp");
			//System.out.println("Student submit khong thanh cong...");
			
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	        throws ServletException, IOException {
	    resp.setContentType("text/html;charset=UTF-8");
	    resp.getWriter().println("<h2>Đây là trang đăng ký student</h2>");
	}

	
}
