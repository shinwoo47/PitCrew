package com.pitcrew.cleanhome.user.model.dto;

public class CleanDTO {
	
	private String name;

	public CleanDTO(String name) {
		super();
		this.name = name;
	}

	public CleanDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CleanDTO [name=" + name + "]";
	}

	
}
