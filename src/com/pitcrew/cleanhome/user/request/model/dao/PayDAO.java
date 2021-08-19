package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.user.request.model.dto.PaymentDTO;

public class PayDAO {

   public List<DeductRateDTO> selectDeductRate(SqlSession session) {
      
      return session.selectList("PayDAO.selectdeductRate");
   }
   
   public int insertDeductPrice1(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertDeductPrice1", payment);
   }
   
   public int selectSetReqNo(SqlSession session) {

	   return session.selectOne("PayDAO.selectSetReqNo");
   }

   public int insertDeductPrice2(SqlSession session, PaymentDTO payment) {
	   
	   return session.insert("PayDAO.insertDeductPrice2", payment);
   }
   public int insertDeductPrice3(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertDeductPrice3", payment);
   }

   public int insertRequest(SqlSession session, PaymentDTO payment) {
     
	   return session.insert("PayDAO.insertRequest", payment);
   }
   
   public int insertReqInfo(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertReqInfo", payment);
   }

   public int insertPayHistory(SqlSession session, PaymentDTO payment) {
     
	   return session.insert("PayDAO.insertPayHistory", payment);
   }

   public int insertProductByReq(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertProductByReq", payment);
   }




}