package com.pitcrew.cleanhome.admin.user.controller;

import java.io.IOException;
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
		List<UserDTO> userList = new UserService().selectAllUserInfoList();
		
		System.out.println("서블릿 유저리스트 : " + userList);
		
		String path = "";
		if(userList != null) {
			path = "/WEB-INF/views/admin/user/userList.jsp";
			request.setAttribute("userList", userList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "사용자 정보 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
