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
		
		String path = "/WEB-INF/views/member/findPwd.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*폼에서 입력한 파라미터 값 변수에 초기화 시켜줌*/
		
		String id = request.getParameter("memId");
		String memName = request.getParameter("memName");
		String email = request.getParameter("email");
		
		MemberDTO setParameter = new MemberDTO();
		setParameter.setId(id);
		setParameter.setMemName(memName);
		setParameter.setEmail(email);
		
		/*dto에 파라미터 넣은 값 확인*/
		System.out.println("selectValue : " + setParameter);
		
		/* 정보 조회를 위해 파라미터 넣은 객체를 서비스에 전달*/
		MemberDTO selectMyPwd = new MemberService().selectMyPwd(setParameter);
		
		/* db 조회한 값 확인*/
		System.out.println("selectMyPwd : " + selectMyPwd);
		
		/* 조회한 값 null값인지 확인*/
		if(selectMyPwd.getId() == null && selectMyPwd.getMemName() == null && selectMyPwd.getEmail() == null) {
			request.setAttribute("message", "입력하신 정보가 조회되지 않습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
			return;
		}
		
		//mail server 설정
		String host = "smtp.naver.com";
		String user = "lsy980416@naver.com";//자신의 네이버 계정
		String password = ""; //자신의 네이버 패스워드 !! 이 부분 혹시 값 초기화 되어 있으면 지워주세요
		
		/*메일 받을 주소*/
		String to_email = selectMyPwd.getEmail();
		
		//SMTP 서버 정보를 설정한다
		Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
        
      //인증 번호 생성기
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        
        String AuthenticationKey = temp.toString();
        System.out.println(AuthenticationKey);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        
        //email 전송
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user, "맡겨줘 홈즈"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            
            //메일 제목
            msg.setSubject("맡겨줘 홈즈 비밀번호 변경을 위한 이메일 인증입니다.");
            //메일 내용
            msg.setText("인증 번호는 :" + temp + "입니다.");
            
            Transport.send(msg);
            System.out.println("이메일 전송");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        HttpSession saveKey = request.getSession();
        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);

        request.setAttribute("id", id);
        request.getRequestDispatcher("/WEB-INF/views/member/retypePwd.jsp").forward(request, response);
	}

}
