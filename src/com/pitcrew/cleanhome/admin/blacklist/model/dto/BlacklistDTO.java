package com.pitcrew.cleanhome.admin.blacklist.model.dto;

public class BlacklistDTO {
	
	private int blacklistNo;
	private int penaltyScoreSum;
	private int memNo;
	
	public BlacklistDTO() {}

	public BlacklistDTO(int blacklistNo, int penaltyScoreSum, int memNo) {
		super();
		this.blacklistNo = blacklistNo;
		this.penaltyScoreSum = penaltyScoreSum;
		this.memNo = memNo;
	}

	public int getBlacklistNo() {
		return blacklistNo;
	}

	public void setBlacklistNo(int blacklistNo) {
		this.blacklistNo = blacklistNo;
	}

	public int getPenaltyScoreSum() {
		return penaltyScoreSum;
	}

	public void setPenaltyScoreSum(int penaltyScoreSum) {
		this.penaltyScoreSum = penaltyScoreSum;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "BlacklistDTO [blacklistNo=" + blacklistNo + ", penaltyScoreSum=" + penaltyScoreSum + ", memNo=" + memNo
				+ "]";
	}
	
	
	
}
