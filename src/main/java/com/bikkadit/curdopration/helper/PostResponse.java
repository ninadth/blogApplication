package com.bikkadit.curdopration.helper;

import java.util.List;

import com.bikkadit.curdopration.payload.PostsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostResponse {

	private List<PostsDto> content;
	private int pageSize;
	private int pageNumber;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;
	public List<PostsDto> getContent() {
		return content;
	}
	public void setContent(List<PostsDto> content) {
		this.content = content;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public PostResponse(List<PostsDto> content, int pageSize, int pageNumber, long totalElements, int totalPages,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PostResponse [content=" + content + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", lastPage=" + lastPage + "]";
	}

	
}
