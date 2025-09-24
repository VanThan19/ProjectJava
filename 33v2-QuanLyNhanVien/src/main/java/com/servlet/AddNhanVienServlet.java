package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.NhanVienDAO;
import com.entity.NhanVien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/addNhanVien")
public class AddNhanVienServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String adr = req.getParameter("adr");
		String chucvu = req.getParameter("chucvu");
		
		NhanVien nv = new NhanVien(name, dob, adr, chucvu);
		NhanVienDAO dao = new NhanVienDAO(DBConnect.getCon());
		
		HttpSession s = req.getSession();
		boolean f = dao.addNhanVien(nv);
		if (f) {
			s.setAttribute("bu", "Them du lieu thanh cong");
			resp.sendRedirect("add_nhanvien.jsp");
		}
		else {
			s.setAttribute("vcl", "Them du lieu khong thanh cong");
			resp.sendRedirect("add_nhanvien.jsp");
		}

	}
	

}
