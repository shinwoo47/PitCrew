package com.pitcrew.cleanhome.admin.resign.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.resign.model.service.ResignMemberService;
import com.pitcrew.cleanhome.admin.user.model.dto.UserDTO;

@WebServlet("/admin/resign/select")
public class SelectResignMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserDTO> resignMemberList = new ResignMemberService().selectAllResignMember();
	
		String path = "";
        if(resignMemberList != null) {
           path = "/WEB-INF/views/admin/resign/resignMemberList.jsp";
           request.setAttribute("resignMemberList", resignMemberList);
        } else {
           path = "/WEB-INF/views/common/failed.jsp";
           request.setAttribute("message", "사용자 정보 조회 실패!");
        }
	}

}
