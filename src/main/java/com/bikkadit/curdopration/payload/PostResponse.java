package com.bikkadit.curdopration.payload;

import java.util.List;

public class PostResponse {

	private List<PostsDto> content;
	
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private long totalPage;
	
	private boolean lastPage;

	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PostsDto> getContent() {
		return content;
	}

	public void setContent(List<PostsDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public PostResponse(List<PostsDto> content, int pageNumber, int pageSize, long totalElements, long totalPage,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPage = totalPage;
		this.lastPage = lastPage;
	}

	@Override
	public String toString() {
		return "PostResponse [content=" + content + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalElements=" + totalElements + ", totalPage=" + totalPage + ", lastPage=" + lastPage + "]";
	}
	
	
}
