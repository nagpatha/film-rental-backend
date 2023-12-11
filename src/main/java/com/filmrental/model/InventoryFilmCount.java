package com.filmrental.model;

public class InventoryFilmCount {
	
	String title;
	Long count;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public InventoryFilmCount(String title, Long count) {
		super();
		this.title = title;
		this.count = count;
	}

}
