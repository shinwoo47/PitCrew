package com.pitcrew.cleanhome.user.request.model.service;

import com.pitcrew.cleanhome.admin.calculator.model.dto.CalSettingDTO;
import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.admin.calculator.model.service.CalculatingService;
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
         
         List<DeductRateDTO> deductRateList = payDAO.selectDeductRate(session);
         System.out.println("controller rate List : " + deductRateList);
         
         int calPrice = payment.getPayPrice();   //소비자 결제금액
         float vat = 0f;            // 부가세
         float cardrate = 0f;         // 카드 수수료율
         float marginrate = 0f;      // 사업장 운영비 공제율
         int supplyPrice = 0;       // 공급가액
         int deductSum = 0;          //공제 합계
         int cleanerincome = 0;       // 해결사 지급 총액
         
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
         
         int deductPrice1  = (int)(Math.floor((calPrice/(1+vat)) / 10)) * 10; // 공급가액
         result += payDAO.insertDeductPrice1(session, payment, deductPrice1);
         
         int deductPrice2  = (int)(Math.floor((calPrice/(1+cardrate)) / 10)) * 10; // 공급가액
         result += payDAO.insertDeductPrice2(session, payment, deductPrice1);
         
         int deductPrice3  = (int)(Math.floor((calPrice/(1+marginrate)) / 10)) * 10; // 공급가액
         result += payDAO.insertDeductPrice3(session, payment, deductPrice1);
         
         
         System.out.println("공급가액 : " + supplyPrice);
         
         deductSum = (int) ((calPrice - supplyPrice) + (calPrice * cardrate) + (calPrice * marginrate)); //부가세 + 카드수수료율 + 운영비  

         cleanerincome = calPrice - deductSum;   //해결사 지급 총액

         System.out.println("공제 총액 : " + deductSum);
         System.out.println("지급 총액 : " + cleanerincome);
         
         payment.setPayPrice(cleanerincome);
         
         if(result == 3) {
            session.commit();
            System.out.println("공제금액 insert 성공");
         } else {
            session.rollback();
            System.out.println("공제금액 insert 실패");
         }
         
         session.close();
         
         return payment;
      }

   public int insertRequest(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      session.close();
      
      return result;
   }

   public int insertReqInfo(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      session.close();
      
      return result;
   }
   public int insertPayHistory(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      session.close();
      
      return result;
   }

   public int insertProductByReq(PaymentDTO payment) {
      
      SqlSession session = getSqlSession();
      
      int result = 0;
      
      session.close();
      
      return result;
   }





}