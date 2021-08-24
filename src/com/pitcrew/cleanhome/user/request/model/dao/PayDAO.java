package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.user.request.model.dto.PaymentDTO;

public class PayDAO {
   
   /* DB에 저장된 공제율 구하기 메소드 */
   public List<DeductRateDTO> selectDeductRate(SqlSession session) {
      
      return session.selectList("PayDAO.selectdeductRate");
   }
   
   /* 공제 부가세 insert 메소드 */
   public int insertDeductPrice1(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertDeductPrice1", payment);
   }
   
   /* 마지막 의뢰 등록 시퀀스 조회 메소드 */
   public int selectSetReqNo(SqlSession session) {

	   return session.selectOne("PayDAO.selectSetReqNo");
   }
   
   /* 공제 카드 수수료율 insert 메소드 */
   public int insertDeductPrice2(SqlSession session, PaymentDTO payment) {
	   
	   return session.insert("PayDAO.insertDeductPrice2", payment);
   }
   
   /* 공제 사업장 운영비 공제율 insert 메소드 */
   public int insertDeductPrice3(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertDeductPrice3", payment);
   }
   
   /* 의뢰 정보 insert 메소드*/
   public int insertRequest(SqlSession session, PaymentDTO payment) {
     
	   return session.insert("PayDAO.insertRequest", payment);
   }
   
   /* 의뢰 상태 관리 insert 메소드*/
   public int insertReqInfo(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertReqInfo", payment);
   }

   /* 결제 내역 insert 메소드 */
   public int insertPayHistory(SqlSession session, PaymentDTO payment) {
     
	   return session.insert("PayDAO.insertPayHistory", payment);
   }

   /* 의뢰별 상품 insert 메소드*/
   public int insertProductByReq(SqlSession session, PaymentDTO payment) {

	   return session.insert("PayDAO.insertProductByReq", payment);
   }




}