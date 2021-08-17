package com.pitcrew.cleanhome.admin.calculator.model.dto;

public class DeductRateDTO {
	
	private int deductNo;
	private String deductName;
	private float rate;
	
	
	
	public DeductRateDTO() {}



	public DeductRateDTO(int deductNo, String deductName, float rate) {
		super();
		this.deductNo = deductNo;
		this.deductName = deductName;
		this.rate = rate;
	}



	public int getDeductNo() {
		return deductNo;
	}



	public void setDeductNo(int deductNo) {
		this.deductNo = deductNo;
	}



	public String getDeductName() {
		return deductName;
	}



	public void setDeductName(String deductName) {
		this.deductName = deductName;
	}



	public float getRate() {
		return rate;
	}



	public void setRate(float rate) {
		this.rate = rate;
	}



	@Override
	public String toString() {
		return "DeductRateDTO [deductNo=" + deductNo + ", deductName=" + deductName + ", rate=" + rate + "]";
	}

	
	
	
	
}
