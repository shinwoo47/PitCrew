package com.pitcrew.cleanhome.admin.blacklist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.blacklist.model.dto.UserDTO;
import com.pitcrew.cleanhome.admin.blacklist.model.service.BlacklistService;


@WebServlet("/admin/blacklist/insert")
public class InsertBlacklistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		//블랙리스트 추가시 메일전송..
		sendMail(email);
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		UserDTO newBlacklist = new UserDTO();
		newBlacklist.setMemNo(memNo);

		BlacklistService blacklistService = new BlacklistService();
		
		int result = blacklistService.insertBlacklist(newBlacklist);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertBlacklist");
			response.setHeader("Refresh","300");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "블랙리스트 추가에 실패하셨습니다.");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	public void sendMail(String receiverMail) {
		String host = "smtp.naver.com"; 
		// 네이버일 경우 네이버 계정, gmail경우 gmail 계정 
		String user = "whdgusqkr406@naver.com"; 
		// 패스워드 
		String password = "Alvinpark9E";  
		
		// SMTP 서버 정보를 설정한다. 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", 587); 
		props.put("mail.smtp.auth", "true"); 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(user, password); } }); 

		try { 
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverMail)); 

			// 메일 제목
			message.setSubject("테스트입니다."); 
			// 메일 내용 
			message.setText("테스트메일!!"); 
			// send the message 
			Transport.send(message); 
			
			System.out.println("Success Message Send"); 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
 }












