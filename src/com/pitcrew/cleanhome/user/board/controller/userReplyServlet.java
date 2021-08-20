package com.pitcrew.cleanhome.user.board.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/board/reply")
public class userReplyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		String path = "/WEB-INF/views/user/board/userReply.jsp";
				
		request.getRequestDispatcher(path).forward(request, response);
	}


}
