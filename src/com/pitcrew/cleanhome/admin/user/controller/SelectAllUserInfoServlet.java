package com.pitcrew.cleanhome.admin.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;
import com.pitcrew.cleanhome.admin.user.model.service.UserService;

@WebServlet("/admin/select/alluserinfo")
public class SelectAllUserInfoServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 관리자 검색 카테고리 
      String searchCondition = "";
      if (request.getParameter("searchCondition") !=  null) {
         searchCondition = request.getParameter("searchCondition");
      }

      /*
       * System.out.println("송준일결과" + request.getParameter("searchDate")); // 가입일 시작
       * System.out.println("송준일결과" + request.getParameter("searchEnbDate")); // 가입일 끝나는 시간
       * System.out.println("송준일결과" + request.getParameter("searchResult")); // 검색 텍스트 결과값
       */
      
      if (searchCondition.equals("")) { // 사용자 관리 페이지에 처음 들어왔을 경우,
         List<UserDTO> userList = new UserService().selectAllUserInfoList();

         String path = "";
         if(userList != null) {
            path = "/WEB-INF/views/admin/user/userList.jsp";
            request.setAttribute("userList", userList);
         } else {
            path = "/WEB-INF/views/common/failed.jsp";
            request.setAttribute("message", "사용자 정보 조회 실패!");
         }
         
         request.getRequestDispatcher(path).forward(request, response);
         
      }else { // 사용자 관리 페이지에서 검색을 할 경우,

         String searchResult = request.getParameter("searchResult");
         
         String searchDate = request.getParameter("searchDate"); // 가입일 시작 날짜
         java.sql.Date date = null;
         if (!searchDate.equals("")) {
             date = java.sql.Date.valueOf(searchDate); 
         } 
           
          String searchEnbDate = request.getParameter("searchEndDate"); // 가입일 끝나는 날짜
          java.sql.Date endDate = null;
         if (!searchEnbDate.equals("")) {
            endDate = java.sql.Date.valueOf(searchEnbDate);
         } 
         
           List<UserDTO> userList = new UserService().searchUserInfomation(searchCondition, searchResult, date, endDate);
           
           String path = "";
         if(userList != null) {
            path = "/WEB-INF/views/admin/user/userList.jsp";
            request.setAttribute("userList", "userList");
         } else {
            path = "/WEB-INF/views/common/failed.jsp";
            request.setAttribute("message", "사용자 정보 조회 실패!");
         }
         
         request.getRequestDispatcher(path).forward(request, response);
      }
      
   }

}