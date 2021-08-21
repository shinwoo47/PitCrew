package com.pitcrew.cleanhome.cleaner.account.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.cleaner.account.model.dto.AccountDTO;
import com.pitcrew.cleanhome.cleaner.account.model.service.AccountService;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;


@WebServlet("/cleaner/account/regist")
public class InsertAccountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/cleaner/registaccount.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountHolder = request.getParameter("accountHolder");
		String bank = request.getParameter("bank");
		String accountNumber = request.getParameter("accountNumber");
		
		HttpSession session = request.getSession();
		CleanerInfoDTO account = new CleanerInfoDTO();
		account.setMemNo(((MemberDTO)session.getAttribute("loginMember")).getMemNo());
		account.setAccountHolder(accountHolder);
		account.setBankName(bank);
		account.setAccountNo(accountNumber);
		
		AccountDTO accountHistory = new AccountDTO();
		accountHistory.setMemNo(((MemberDTO)session.getAttribute("loginMember")).getMemNo());
		accountHistory.setPreAccountHolder(accountHolder);
		accountHistory.setPreBankName(bank);
		accountHistory.setPreAccountNo(accountNumber);
		
		System.out.println("account : " + account);
			
		AccountService accountService = new AccountService();
		int result = accountService.updateAccount(account, accountHistory);             //해결사 계좌 등록 , 해결사 계좌 기록 등록
		System.out.println("insertAccount : " + result);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertAccount");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "계좌 등록 실패 !");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
