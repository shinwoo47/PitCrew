package com.pitcrew.cleanhome.admin.request.model.dto;

import java.sql.Date;

import com.pitcrew.cleanhome.admin.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.admin.product.model.dto.ProductReqDTO;

public class RequestDTO {
	
	private int reqNo;
	private java.sql.Date serviceDate;
	private String wantThing;
	private MemberDTO cleanerNo;
	private ReqInfoDTO reqDate;
	private MemberDTO userNo;
	private String status;
	private ProductReqDTO productNo;
	private ProductReqDTO productName;
	
	public RequestDTO() {}

	

	
	
}
