package com.pitcrew.cleanhome.user.request.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.calculator.model.dto.DeductRateDTO;
import com.pitcrew.cleanhome.user.request.model.dto.PaymentDTO;

public class PayDAO {

   public List<DeductRateDTO> selectDeductRate(SqlSession session) {
      
      return session.selectList("CalculatingDAO.selectdeductRate");
   }
   
   public int insertDeductPrice1(SqlSession session, PaymentDTO payment, int deductPrice1) {
      // TODO Auto-generated method stub
      return 0;
   }


   public int insertDeductPrice2(SqlSession session, PaymentDTO payment, int deductPrice1) {
      // TODO Auto-generated method stub
      return 0;
   }
   public int insertDeductPrice3(SqlSession session, PaymentDTO payment, int deductPrice1) {
      // TODO Auto-generated method stub
      return 0;
   }


}
