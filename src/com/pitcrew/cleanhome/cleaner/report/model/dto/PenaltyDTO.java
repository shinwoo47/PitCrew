package com.pitcrew.cleanhome.cleaner.report.model.dto;

import java.io.Serializable;

public class PenaltyDTO implements Serializable{

	private String penaltyCategoryCode;
	private int penaltyScore;
	
	public PenaltyDTO() {}

	public PenaltyDTO(String penaltyCategoryCode, int penaltyScore) {
		super();
		this.penaltyCategoryCode = penaltyCategoryCode;
		this.penaltyScore = penaltyScore;
	}

	public String getPenaltyCategoryCode() {
		return penaltyCategoryCode;
	}

	public void setPenaltyCategoryCode(String penaltyCategoryCode) {
		this.penaltyCategoryCode = penaltyCategoryCode;
	}

	public int getPenaltyScore() {
		return penaltyScore;
	}

	public void setPenaltyScore(int penaltyScore) {
		this.penaltyScore = penaltyScore;
	}

	@Override
	public String toString() {
		return "PenaltyDTO [penaltyCategoryCode=" + penaltyCategoryCode + ", penaltyScore=" + penaltyScore + "]";
	}
	
	
}
