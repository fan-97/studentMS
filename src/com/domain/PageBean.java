package com.domain;

import java.util.List;

/**
 * 封装分页查询的数据
 * 
 * @author Fan
 *
 */
public class PageBean{
	private int currentPage;// 当前页
	private int totalPage;// 总共的页数
	private int totalSize;// 总的记录数
	private int startIndex;// 起始索引
	private int startPage;// 开始页码
	private int nextPage;//下一页
	private int prePage;//上一页
	private int endPage;// 结束页码
	private int pageSize = 10;// 每一页显示多少条数据,默认10条

	private List<Student> list;// 当前分页显示的对象集合
	private String url;// 跳转的链接

	public PageBean(int currentPage, int totalSize, int pageSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
		this.pageSize = pageSize;

		// 计算总的页数
		totalPage = totalSize % pageSize == 0 ? (totalSize / pageSize) : (totalSize / pageSize + 1);
		// 计算开始索引
		startIndex = (currentPage - 1) * pageSize;

		// 计算开始页码和结束页码

		startPage = currentPage - 4;//当当前的页码超过一半的时候，页码就不是从1开始10结束了
		endPage = currentPage + 4;

		if (totalPage > 9) {
			// 一共显示9个页码
			if (startPage < 1) {
				
				startPage = 1;
				endPage = startPage + 8;
			}

			if (endPage > totalPage) {
				endPage = totalPage;
				startIndex = endPage - 8;
			}
		} else {
			startPage = 1;
			endPage = totalPage;
		}

	}

	
	
	
	public int getNextPage() {
		return currentPage+1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrePage() {
		return currentPage-1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

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

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
