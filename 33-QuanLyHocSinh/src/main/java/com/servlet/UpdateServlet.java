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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String addr = req.getParameter("addr");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id")); 
		
		Student student = new Student(id,name,dob,addr,qualification,email);
		
		StudentDAO dao = new StudentDAO(DBConnect.getConn());
		
		HttpSession session = req.getSession();
		boolean f = dao.updateStudent(student);
		
		if (f) {
			session.setAttribute("helo", " update thanh cong");
			resp.sendRedirect("index.jsp");
//			System.out.println("Student Details submit thanh cong...");
		}else {
			session.setAttribute("ErrorHelo", "update un thanh cong");
			resp.sendRedirect("index.jsp");
			//System.out.println("Student submit khong thanh cong...");
			
		}
	}

	
}
