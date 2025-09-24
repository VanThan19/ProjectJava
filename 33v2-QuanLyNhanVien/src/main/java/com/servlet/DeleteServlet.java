package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.NhanVienDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		NhanVienDAO dao = new NhanVienDAO(DBConnect.getCon());
		boolean f = dao.deleteNhanVien(id);
		
       HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("capnhat", "delete thanh cong");
			resp.sendRedirect("index.jsp");
//			System.out.println("Student Details submit thanh cong...");
		}else {
			session.setAttribute("khong", "delete un thanh cong");
			resp.sendRedirect("index.jsp");
			//System.out.println("Student submit khong thanh cong...");
			
		}
	}
	

}
