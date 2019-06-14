package com.petmatch.PetMatch.entity;

public class Pagination {

	private Long count_per_page;
	private Long total_count;
	private Long total_pages;
	
	public Pagination(Long count_per_page, Long count, Long total_count, Long total_pages) {
		super();
		this.count_per_page = count_per_page;
		this.total_count = total_count;
		this.total_pages = total_pages;
	}

	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getCount_per_page() {
		return count_per_page;
	}

	public void setCount_per_page(Long count_per_page) {
		this.count_per_page = count_per_page;
	}


	public Long getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Long total_count) {
		this.total_count = total_count;
	}

	public Long getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Long total_pages) {
		this.total_pages = total_pages;
	}

	@Override
	public String toString() {
		return "Pagination [count_per_page=" + count_per_page + ", total_count=" + total_count + ", total_pages="
				+ total_pages + "]";
	}


	
	
}
