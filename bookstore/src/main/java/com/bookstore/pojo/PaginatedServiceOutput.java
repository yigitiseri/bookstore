package com.bookstore.pojo;

import java.util.List;

public class PaginatedServiceOutput {
	
	private String category;
	private String nextPage;
	private List<PaginatedItem> items;
	private String totalPages;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<PaginatedItem> getItems() {
		return items;
	}
	public void setItems(List<PaginatedItem> items) {
		this.items = items;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
