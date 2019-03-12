package com.Bos.web.jdbc;

public class ToDo {
	private int id;
	private String description;

	public ToDo(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public ToDo(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + "]";
	}

	
}
