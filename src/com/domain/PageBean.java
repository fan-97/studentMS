package com.domain;

import java.util.List;

/**
 * 封装分页查询的数据
 * @author Fan
 *
 */
public class PageBean<T> {
	private int currentPage;//当前页
	private int totalPage;//总共的页数
	private int totalSize;//总的记录数
	private int pageSize;//每一页显示多少条数据
	private List<T> list;//当前分页显示的对象集合
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
