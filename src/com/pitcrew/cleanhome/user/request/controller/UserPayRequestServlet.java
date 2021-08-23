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
      
      HttpSession session = request.getSession();
      
      MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");

      PaymentDTO payment = new PaymentDTO();
      
//      int memNoUser = loginMember.getMemNo();
      int productNo = Integer.parseInt(request.getParameter("productNo"));
      int optionNo1 = Integer.parseInt(request.getParameter("reqOption1"));
      int optionNo2 = Integer.parseInt(request.getParameter("reqOption2"));
      int price = Integer.parseInt(request.getParameter("serPrice"));
      String impUid = request.getParameter("impUid");
      int serPrice = Integer.parseInt(request.getParameter("serPrice"));
      String reqDate = request.getParameter("reqDate");
      String reqReq = request.getParameter("reqReq");
      
      SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
      
      /* RequestInfoDTO */
      try {
         payment.setReqDate(format2.parse(reqDate));
      } catch (ParseException e) {
         e.printStackTrace();
      }
      payment.setReqReq(reqReq);
      payment.setMemNoUser(loginMember.getMemNo());
      
      //상품번호
      int number[] = new int[3];
      number[0] = productNo;
      number[1] = optionNo1;
      number[2] = optionNo2;
      
      //상품번호
      payment.setSerNo(number);
      //결제번호
      payment.setPayApprovalNo(impUid);
      //결제금액
      payment.setPayPrice(serPrice);
     /*ProductByReqDTO*/
      PayServices payServices = new PayServices();
      
      int result = 0;
      payment = payServices.insertIndirect(payment);
      result += payServices.insertRequest(payment);
      result += payServices.insertReqInfo(payment);
      result += payServices.insertPayHistory(payment);
      result += payServices.insertProductByReq(payment);
      
      String path = "";
      
      if(result >= 5) {
         path = "/WEB-INF/views/user/services.jsp";
      } else {
         path ="/WEB-INF/views/common/failed.jsp";
         request.setAttribute("message", "insert실패");
      }
         
      
      request.getRequestDispatcher(path).forward(request, response);
      
      
    
      
   }

}