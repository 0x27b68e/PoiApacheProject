package com.quan.PoiDemo;

public class NhanVien {

	private String emid;
	//
	//
	private String name;
	private String designation;

	public String getEmid() {
		return emid;
	}

	public void setEmid(String emid) {
		this.emid = emid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String toString() {
		return emid + " " + name + " " + designation;

	}

}
