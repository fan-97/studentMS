package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.StudentDao;
import com.domain.PageBean;
import com.domain.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.JDBCUtil;
import com.util.MyUtils;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into stu values (null,?,?,?,?,?,?)";
		Object[] params = { student.getSname(), student.getGender(), student.getPhone(), student.getBirthday(),
				student.getHobby(), student.getInfo() };
		runner.update(sql, params);
	}

	@Override
	public Student getStuById(int sid) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu where sid = ?";
		Student stu = null;
		try {
			stu = runner.query(sql, new BeanHandler<Student>(Student.class), sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public void updateStu(Student stu) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?";
		try {
			runner.update(sql, stu.getSname(), stu.getGender(), stu.getPhone(), stu.getBirthday(), stu.getHobby(),
					stu.getInfo(), stu.getSid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean delStuById(int sid) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from stu where sid = ?";
		int num = 0;
		try {
			num = runner.update(sql, sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num >= 1 ? true : false;
	}

	@Override
	public boolean delStuByName(String sname) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from stu where sname = ?";
		int num = 0;
		try {
			num = runner.update(sql, sname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num >= 1 ? true : false;
	}

	@Override
	public List<Student> VagueQuery(String sname, String gender) {
		List<Student> list = null;
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu where 1=1 ";
		// 1.如果只有姓名 就查询 select * from stu where sname like ?;
		// 2.如果只有性别 就查询 select * from stu where gender= ?;
		// 3.两个都没有就查询全部
		if (!MyUtils.isEmptyStr(sname)) {
			sql += "and sname like '%" + sname + "%'";
		}
		if (!MyUtils.isEmptyStr(gender)) {
			sql += " and gender = '" + gender + "'";
		}
		try {
			list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalSize() {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select count(*) from stu";
		Long size = null;
		try {
			size = (Long) runner.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size.intValue();
	}
	
	@Override
	public List<Student> getCurrentPageUser(int currentPage) {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu limit " + (currentPage - 1) * pageSize + "," + pageSize;
		List<Student> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
