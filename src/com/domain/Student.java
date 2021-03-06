﻿package com.domain;

import java.util.Date;

 /** 
 * @ClassName: Student 
 * @Description: TODO
 * @author: moon
 * @date: 2019年4月25日 下午8:53:47  
 */
public class Student {

	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String info;
	private String grade;
	
	public Student() {
	}
	
	public Student( String sname, String gender, String phone, Date birthday, String hobby, String info,String grade) {
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.info = info;
		this.grade = grade;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", hobby=" + hobby + ", info=" + info + ", grade=" + grade + "]";
	}
	
}
