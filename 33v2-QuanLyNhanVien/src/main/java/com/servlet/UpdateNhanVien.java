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

@WebServlet("/update")
public class UpdateNhanVien extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String adr = req.getParameter("adr");
		String chucvu = req.getParameter("chucvu");
		int id = Integer.parseInt(req.getParameter("id")); 
		
		NhanVien nv = new NhanVien(id, name, dob, adr, chucvu);
		NhanVienDAO dao = new NhanVienDAO(DBConnect.getCon());
		
		HttpSession s = req.getSession();
		boolean f = dao.updateNhanVien(nv);
		
		if(f) {
			s.setAttribute("capnhat", "Cap nhat thanh cong");
			resp.sendRedirect("index.jsp");
		}
		else {
			s.setAttribute("khong", "Cap nhat khong thanh cong");
			resp.sendRedirect("index.jsp");
		}
	}
	

}
