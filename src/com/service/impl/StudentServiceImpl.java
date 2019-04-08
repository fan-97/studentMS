package com.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.PageBean;
import com.domain.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	@Override
	public Student getStuById(int sid) {
		StudentDao dao = new StudentDaoImpl();
		return dao.getStuById(sid);
	}

	@Override
	public void updateStu(Student stu) {
		StudentDao dao = new StudentDaoImpl();
		dao.updateStu(stu);
	}

	@Override
	public boolean delStuById(int id) {
		StudentDao dao = new StudentDaoImpl();
		return dao.delStuById(id);
	}

	@Override
	public boolean delStuByName(String sname) {
		StudentDao dao = new StudentDaoImpl();
		return dao.delStuByName(sname);
	}

	@Override
	public PageBean<Student> VagueQuery(String sname, String gender,int currentPage) {
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.VagueQuery(sname, gender);
		PageBean<Student> pageBean = new PageBean<>();
		// 1.获取总的记录数
		int totalSize = list.size();
		pageBean.setTotalSize(totalSize);
		// 2.获取总的页数
		int totalPage = totalSize % StudentDao.pageSize == 0 ? totalSize / StudentDao.pageSize
				: (totalSize / StudentDao.pageSize + 1);
		pageBean.setTotalPage(totalPage);
		// 3.获取当前页的学生集合
		pageBean.setList(list.subList(currentPage-1, totalSize>=StudentDao.pageSize?StudentDao.pageSize:totalSize));
		// 4.设置当前页
		pageBean.setCurrentPage(currentPage);
		// 5.每一页显示的数据条数
		pageBean.setPageSize(StudentDao.pageSize);
		return pageBean;
	}

	@Override
	public PageBean<Student> getCurrentPageUser(int currentPage) {
		PageBean<Student> pageBean = new PageBean<>();
		StudentDao dao = new StudentDaoImpl();
		// 1.获取总的记录数
		int totalSize = dao.getTotalSize();
		pageBean.setTotalSize(totalSize);
		// 2.获取总的页数
		int totalPage = totalSize % StudentDao.pageSize == 0 ? totalSize / StudentDao.pageSize
				: (totalSize / StudentDao.pageSize + 1);
		pageBean.setTotalPage(totalPage);
		// 3.获取当前页的学生集合
		pageBean.setList(dao.getCurrentPageUser(currentPage));
		// 4.设置当前页
		pageBean.setCurrentPage(currentPage);
		// 5.每一页显示的数据条数
		pageBean.setPageSize(StudentDao.pageSize);
		return pageBean;
	}

}
