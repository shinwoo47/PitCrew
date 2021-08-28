package com.pitcrew.cleanhome.member.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
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
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.member.model.service.MemberService;

@WebServlet("/member/findPwd")
public class FindMemberPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 비밀번호 찾기 페이지로 이동한다. */
		String path = "/WEB-INF/views/member/findPwd.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 폼에서 입력한 파라미터 값 변수에 초기화 시켜줌 */
		String id = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		
		/* 초기화 한 변수를 MemberDTO 타입에 set메소드를 이용해 값을 담아준다.*/
		MemberDTO setParameter = new MemberDTO();
		setParameter.setId(id);
		setParameter.setMemName(memName);
		setParameter.setEmail(email);
		
		/* selectMyPwd에 담아준 값을 인자값으로 전달 후 해당 아이디가 있는지 조회*/
		MemberDTO selectMyPwd = new MemberService().selectMyPwd(setParameter);
		
		/* 성공 실패 시 경로 설정 */
		String path = "";
		
		/* 조회한 값 null값인지 확인*/
		if(selectMyPwd != null) {
			
			/* mail server 설정*/
			String host = "smtp.naver.com";
			String user = "lsy980416@naver.com";	/* 자신의 네이버 계정 */
			String password = ""; 					/* 자신의 네이버 패스워드 !! 이 부분 혹시 값 초기화 되어 있으면 지워주세요 */
			
			/* 메일 받을 주소 */
			String to_email = selectMyPwd.getEmail();
			
			/* SMTP 서버 정보를 설정한다 */
			Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", 465);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
	        
	        /* 난수를 생성해 인증 번호를 만든다 */
	        StringBuffer temp =new StringBuffer();
	        Random rnd = new Random();
	        for(int i = 0; i < 10; i++) {
	        
	            int rIndex = rnd.nextInt(3);
	            switch (rIndex) {
	            case 0:
	            	
	                /* a-z */
	                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
	                break;
	            case 1:
	            	
	            	/* A-Z */
	                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
	                break;
	            case 2:
	            	
	                /* 0-9 */
	                temp.append((rnd.nextInt(10)));
	                break;
	            }
	        }
	        
	        /* 생성한 난수를 toString형태로 값을 초기화 */
	        String AuthenticationKey = temp.toString();
	        
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user,password);
	            }
	        });
	        
	        /* email 전송  */
	        try {
	        	
	            MimeMessage msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(user, "맡겨줘 홈즈"));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
	            
	            /* 메일 제목 */
	            msg.setSubject("맡겨줘 홈즈 비밀번호 변경을 위한 이메일 인증입니다.");

	            /* 메일 내용 */
	            msg.setText("인증 번호는 :" + temp + "입니다.");
	            
	            /* 메세지를 입력한 이메일로 보낸다. */
	            Transport.send(msg);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        /* 인증번호를 비교하기 위해 세션에 저장한다. */
	        HttpSession saveKey = request.getSession();
	        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
	        
	        /* 인증번호 발송 성공 시 페이지 이동 */
	        path = "/WEB-INF/views/common/failedInput.jsp";
	        request.setAttribute("id", id);
	        request.setAttribute("successCode", "sendCerticationNum");
	        request.getRequestDispatcher(path).forward(request, response);
			
		} else {
			
			/* db에서 조회된 값이 null 값일 때 로직 */
			path = "/WEB-INF/views/common/failedInput.jsp";
			request.setAttribute("failedCode", "failedInput");  
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

}
