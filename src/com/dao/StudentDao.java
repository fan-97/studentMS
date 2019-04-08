package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.User;

import com.domain.PageBean;
import com.domain.Student;

public interface StudentDao {
	
	int pageSize = 5;//每一页显示的数据条数
	
	/**
	 * 查询所有学生信息
	 * @throws SQLException 
	 */
	public List<Student> findAll() throws SQLException;
	
	/**
	 * 根据姓名和性别模糊查询
	 * @param sname
	 * @param gender
	 * @return
	 */
	public List<Student> VagueQuery(String sname,String gender);
	
	/**
	 * 根据用户id获取用户
	 * @param sid
	 * @return
	 */
	public Student getStuById(int sid);
	
	/**
	 * 往数据库中添加学生
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
	public boolean delStuById(int sid);
	
	/**
	 * 根据学生姓名删除学生
	 * @param sname
	 * @return
	 */
	public boolean delStuByName(String sname);
	
	/**
	 * 获取总的记录数
	 * @return
	 */
	public int getTotalSize();
	
	/**
	 * 获取当前页的学生
	 * @param currentPage
	 */
	public List<Student> getCurrentPageUser(int currentPage);
	
	
}
