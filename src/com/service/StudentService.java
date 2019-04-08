package com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.User;

import com.domain.PageBean;
import com.domain.Student;

public interface StudentService {
	/**
	 * 查找全部学生
	 * @throws SQLException 
	 */
	public List<Student> findAll() throws SQLException;
	
	/**
	 * 根据姓名和性别模糊查询
	 * @param sname
	 * @param gender
	 * @return
	 */
	public PageBean<Student> VagueQuery(String sname,String gender,int currentPage);
	
	/**
	 * 根据用户id获取用户
	 * @param sid
	 * @return
	 */
	public Student getStuById(int sid);
	
	/**
	 * 插入学生
	 * @param student
	 * @throws SQLException 
	 */
	public void insert(Student student) throws SQLException;
	
	/**
	 * 更新学生信息
	 * @param stu
	 */
	public void updateStu(Student stu);
	
	/**
	 * 根据id删除学生
	 * @param id
	 * @return
	 */
	public boolean delStuById(int id);
	
	/**
	 * 根据学生姓名删除学生
	 * @param sname
	 * @return
	 */
	public boolean delStuByName(String sname);
	
	/**
	 * 获取当前页的数据
	 * @param currentPage
	 */
	public PageBean<Student> getCurrentPageUser(int currentPage);
}
