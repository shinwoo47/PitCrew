package com.pitcrew.cleanhome.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pitcrew.cleanhome.member.model.service.MemberService;


@WebServlet("/member/idCheck")
public class IdCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		
		System.out.println("id : " + id);
		
		MemberService memberService = new MemberService();
		int idCount = memberService.idCheck(id);
		
		PrintWriter out = response.getWriter();
		
		out.print(idCount);
		
		out.flush();
		out.close();
	}

}
