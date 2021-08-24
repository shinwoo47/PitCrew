package com.pitcrew.cleanhome.user.request.controller;

import java.io.IOException; 
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.request.model.dto.PaymentDTO;
import com.pitcrew.cleanhome.user.request.model.service.PayServices;

@WebServlet("/user/pay/request")
public class UserPayRequestServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	  /**
	   *  결제 성공후 DB에 결제 정보 insert
	   */
	   
      HttpSession session = request.getSession();
      
      /* 세션에 저장된 loginMember MemberDTO 타입으로 캐스팅*/
      MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");	
      
      /* 결제 정보 DTO 초기화 */
      PaymentDTO payment = new PaymentDTO();
      
      int productNo = Integer.parseInt(request.getParameter("productNo"));			/* 청소 번호 */
      int optionNo1 = Integer.parseInt(request.getParameter("reqOption1"));			/* 옵션 번호1 */
      int optionNo2 = Integer.parseInt(request.getParameter("reqOption2"));			/* 옵션 번호2 */
      String impUid = request.getParameter("impUid");								/* 승인 번호 */
      int serPrice = Integer.parseInt(request.getParameter("serPrice"));			/* 가격 */
      String reqDate = request.getParameter("reqDate");								/* 시작 날짜 */
      String reqReq = request.getParameter("reqReq");								/* 요구 사항 */
      
      SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
      
      try {
    	  
    	  /* 날짜 형식 지정 */
         payment.setReqDate(format2.parse(reqDate));
      } catch (ParseException e) {
         e.printStackTrace();
      }
      
      /* 크기가 3인 number변수 초기화 */
      int number[] = new int[3];													
      number[0] = productNo;
      number[1] = optionNo1;
      number[2] = optionNo2;
      
      payment.setReqReq(reqReq);
      payment.setMemNoUser(loginMember.getMemNo());
      payment.setSerNo(number);				
      payment.setPayApprovalNo(impUid);		
      payment.setPayPrice(serPrice);		
      
      PayServices payServices = new PayServices();		
      
      int result = 0;
      
      /* 공제율 select 후 insert, 가격에서 세금 제한 후 해결사 지급 총액 구하기 */
      payment = payServices.insertIndirect(payment);
      
      /* 결제 정보 insert */
      result += payServices.insertRequest(payment);
      result += payServices.insertReqInfo(payment);
      result += payServices.insertPayHistory(payment);
      result += payServices.insertProductByReq(payment);
      
      String path = "";
      
      if(result >= 4) {
         path = "/WEB-INF/views/user/services.jsp";
      } else {
         path ="/WEB-INF/views/common/failed.jsp";
         request.setAttribute("message", "insert실패");
      }
         
      
      request.getRequestDispatcher(path).forward(request, response);
      
      
    
      
   }

}