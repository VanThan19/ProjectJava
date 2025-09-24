package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.NhanVien;

public class NhanVienDAO {
	private Connection conn;

	public NhanVienDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addNhanVien (NhanVien nv) {
		
		boolean f = false ;
		try {
			
			PreparedStatement ps = conn.prepareStatement("Insert into NhanVien (name,dob,adr,chucvu) values (?,?,?,?)");
			ps.setString(1, nv.getName());
			ps.setString(2, nv.getDob());
			ps.setString(3, nv.getAdr());
			ps.setString(4, nv.getChucvu());
			
			int a = ps.executeUpdate();
			if(a==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> list = new ArrayList<NhanVien>();
		NhanVien nv = null;
		
		try {
			String sql = "Select * from NhanVien";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				nv = new NhanVien();
				nv.setId(rs.getInt(1));
				nv.setName(rs.getString(2));
				nv.setDob(rs.getString(3));
				nv.setAdr(rs.getString(4));
				nv.setChucvu(rs.getString(5));
				
				list.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public NhanVien getNhanVienById(int id) {
		NhanVien nv = null;
		
		try {
			String sql = "Select * from NhanVien where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				nv = new NhanVien();
				nv.setId(rs.getInt(1));
				nv.setName(rs.getString(2));
				nv.setDob(rs.getString(3));
				nv.setAdr(rs.getString(4));
				nv.setChucvu(rs.getString(5));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	public boolean updateNhanVien(NhanVien nv) {
		boolean f = false;
		try {
			String sql = "Update NhanVien set Name = ?, Dob =?, Adr = ?,Chucvu = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nv.getName());
			ps.setString(2, nv.getDob());
			ps.setString(3, nv.getAdr());
			ps.setString(4, nv.getChucvu());
			ps.setInt(5, nv.getId());
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public boolean deleteNhanVien(int id) {
		boolean f = false ;
		try {
			String sql = "Delete from NhanVien where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
