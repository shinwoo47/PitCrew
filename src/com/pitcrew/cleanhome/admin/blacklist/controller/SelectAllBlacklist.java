package com.pitcrew.cleanhome.admin.blacklist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;
import com.pitcrew.cleanhome.admin.blacklist.model.service.BlacklistService;

@WebServlet("/admin/select/allblacklist")
public class SelectAllBlacklist extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserDTO> blacklistList = new BlacklistService().selectAllBlacklist();
		String path = "";
        if(blacklistList != null) {
           path = "/WEB-INF/views/admin/blacklist/blacklistList.jsp";
           request.setAttribute("blacklistList", blacklistList);
        } else {
           path = "/WEB-INF/views/common/failed.jsp";
           request.setAttribute("message", "블랙리스트 조회 실패!");
        }
        
        request.getRequestDispatcher(path).forward(request, response);
	}

}
