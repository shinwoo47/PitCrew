package com.pitcrew.cleanhome.cleaner.calculate.model.dto;

public class ProductSumDTO {
	
	private int room;
	private int bathroom;
	private int all;
	private int window;
	private int dishes;
	
	public ProductSumDTO() {}

	public ProductSumDTO(int room, int bathroom, int all, int window, int dishes) {
		super();
		this.room = room;
		this.bathroom = bathroom;
		this.all = all;
		this.window = window;
		this.dishes = dishes;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getWindow() {
		return window;
	}

	public void setWindow(int window) {
		this.window = window;
	}

	public int getDishes() {
		return dishes;
	}

	public void setDishes(int dishes) {
		this.dishes = dishes;
	}

	@Override
	public String toString() {
		return "ProductSumDTO [room=" + room + ", bathroom=" + bathroom + ", all=" + all + ", window=" + window
				+ ", dishes=" + dishes + "]";
	}
	
	
}
