package com.entity;

public class NhanVien {
	
	private int id;
	private String name;
	private String dob;
	private String adr;
	private String chucvu;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String name, String dob, String adr, String chucvu) {
		super();
		this.name = name;
		this.dob = dob;
		this.adr = adr;
		this.chucvu = chucvu;
	}
	
	public NhanVien(int id, String name, String dob, String adr, String chucvu) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.adr = adr;
		this.chucvu = chucvu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", name=" + name + ", dob=" + dob + ", adr=" + adr + ", chucvu=" + chucvu + "]";
	}
	
	

}
