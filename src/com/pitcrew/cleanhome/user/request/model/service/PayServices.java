package com.pitcrew.cleanhome.user.request.model.service;

import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.user.request.model.dao.PayDAO;
import com.pitcrew.cleanhome.user.request.model.dto.PaymentDTO;

import org.apache.ibatis.session.SqlSession;
import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

public class PayServices {

      private final PayDAO payDAO;

      public PayServices() {

         payDAO = new PayDAO();

      }
      
      public PaymentDTO insertIndirect(PaymentDTO payment) {
         
         SqlSession session = getSqlSession();
         
         /* 공제율 불러오기 메소드 */
         List<DeductRateDTO> deductRateList = payDAO.selectDeductRate(session);
         
         int calPrice = payment.getPayPrice();  				 /*소비자 결제금액 */
         float vat = 0f;          								 /* 부가세 */
         float cardrate = 0f;         							 /* 카드 수수료율 */
         float marginrate = 0f;       							 /* 사업장 운영비 공제율 */
         int supplyPrice = 0;       							 /* 공급가액 */
         int deductSum = 0;          							 /* 공제 합계 */
         int cleanerincome = 0;       							 /* 해결사 지급 총액 */
         		
         for(int j = 0; j < deductRateList.size(); j++) {
            if((deductRateList.get(j).getDeductName()).equals("VAT")) {
               vat = deductRateList.get(j).getRate();
            } else if((deductRateList.get(j).getDeductName()).equals("cardrate")) {
               cardrate = deductRateList.get(j).getRate();
            } else if((deductRateList.get(j).getDeductName()).equals("margin")) {
               marginrate = deductRateList.get(j).getRate();
            }
         }
         
         int result = 0;
         
         int deductPrice1  = (int)(Math.floor((calPrice/(1+vat)) / 10)) * 10; 
         payment.setDeductPrice(deductPrice1);
         
         /* 공제 부가세 insert */
         result += payDAO.insertDeductPrice1(session, payment);
         
         /* 마지막 의뢰 등록 시퀀스 조회 */
         payment.setReqNo(payDAO.selectSetReqNo(session));
         
         int deductPrice2  =  (int) (calPrice * cardrate); 
         payment.setDeductPrice(deductPrice2);
         
         /* 공제 카드 수수료율 insert */
         result += payDAO.insertDeductPrice2(session, payment);
         
         int deductPrice3  = (int) (calPrice * marginrate); 
         payment.setDeductPrice(deductPrice3);
         
         /* 공제 사업장 운영비 공제율 insert */
         result += payDAO.insertDeductPrice3(session, payment);
         
         /* 부가세 + 카드수수료율 + 운영비  */
         deductSum = (int) ((calPrice - deductPrice1) + (deductPrice2) + (deductPrice3)); 
         
         /* 해결사 지급 총액 */
         cleanerincome = calPrice - deductSum; 											  
         payment.setDeductPrice(cleanerincome);
         
         /* insert 성공시 commit */
         if(result == 3) {
        	 session.commit();
         } else {
            session.rollback();
         }
         
         session.close();
         
         return payment;
      }

   public int insertRequest(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      result = payDAO.insertRequest(session, payment);
      
      if(result > 0 ) {
    	 session.commit();
      } else {
         session.rollback();
      }
      
      session.close();
      
      return result;
   }

   public int insertReqInfo(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      result = payDAO.insertReqInfo(session, payment);
      
      if(result > 0 ) {
    	 session.commit();
      } else {
         session.rollback();
      }
      
      session.close();
      
      return result;
   }
   public int insertPayHistory(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      result = payDAO.insertPayHistory(session, payment);
      
      if(result > 0 ) {
    	 session.commit();
      } else {
         session.rollback();
      }
      
      session.close();
      
      return result;
   }

   public int insertProductByReq(PaymentDTO payment) {
	   
	  /**
	   * 주 청소, 청소 옵션 선택시 insert 
	   */
	   
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      if(payment.getSerNo()[0] > 0 ) {
    	  
    	  payment.setSerNoa(payment.getSerNo()[0]);
    	  result = payDAO.insertProductByReq(session, payment);
      }
      
      if(payment.getSerNo()[1] > 0 ) {
    	  
          payment.setSerNoa(payment.getSerNo()[1]);
          result = payDAO.insertProductByReq(session, payment);
      }
      
      if(payment.getSerNo()[2] > 0 ) {
    	  
          payment.setSerNoa(payment.getSerNo()[2]);
          result = payDAO.insertProductByReq(session, payment);
      }
      
      
      if(result > 0 ) {
         session.commit();
      } else {
         session.rollback();
      }
      
      session.close();
      
      return result;
   }





}