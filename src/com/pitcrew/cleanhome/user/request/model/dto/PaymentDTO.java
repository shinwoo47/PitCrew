package com.pitcrew.cleanhome.user.request.model.dto;

import java.util.Arrays;
import java.util.Date;

public class PaymentDTO {
   
   private int payPrice;         //결제금액
   private String payApprovalNo;   //결제번호
   
   private java.util.Date reqDate;   //의뢰일시
   private String reqReq;         //요청사항
   private int memNoUser;         //의뢰회원번호
   private int[] serNo;            //상품번호
   
   public PaymentDTO() {
      super();
   }

   public PaymentDTO(int payPrice, String payApprovalNo, Date reqDate, String reqReq, int memNoUser, int[] serNo) {
      super();
      this.payPrice = payPrice;
      this.payApprovalNo = payApprovalNo;
      this.reqDate = reqDate;
      this.reqReq = reqReq;
      this.memNoUser = memNoUser;
      this.serNo = serNo;
   }

   public int getPayPrice() {
      return payPrice;
   }

   public void setPayPrice(int payPrice) {
      this.payPrice = payPrice;
   }

   public String getPayApprovalNo() {
      return payApprovalNo;
   }

   public void setPayApprovalNo(String payApprovalNo) {
      this.payApprovalNo = payApprovalNo;
   }

   public java.util.Date getReqDate() {
      return reqDate;
   }

   public void setReqDate(java.util.Date reqDate) {
      this.reqDate = reqDate;
   }

   public String getReqReq() {
      return reqReq;
   }

   public void setReqReq(String reqReq) {
      this.reqReq = reqReq;
   }

   public int getMemNoUser() {
      return memNoUser;
   }

   public void setMemNoUser(int memNoUser) {
      this.memNoUser = memNoUser;
   }

   public int[] getSerNo() {
      return serNo;
   }

   public void setSerNo(int[] serNo) {
      this.serNo = serNo;
   }

   @Override
   public String toString() {
      return "PaymentDTO [payPrice=" + payPrice + ", payApprovalNo=" + payApprovalNo + ", reqDate=" + reqDate
            + ", reqReq=" + reqReq + ", memNoUser=" + memNoUser + ", serNo=" + Arrays.toString(serNo) + "]";
   }
   
}