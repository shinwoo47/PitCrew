package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;



@WebServlet("/cleaner/request/accept")
public class EnrollRequestAcceptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));                 //의뢰 번호
		String status = request.getParameter("status");                        //의뢰 상태
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
		
		RequestDTO requestDto = new RequestDTO();
		requestDto.setReqNo(no);
		requestDto.setReqStatus(status);
		requestDto.setMemNoCleaner(member.getMemNo());

		System.out.println(status);
		System.out.println("reqNo : " + no);

		RequestService requestService = new RequestService();

		int result = requestService.acceptRequest(requestDto);                           //의뢰 매칭(의뢰해결사등록)(의뢰 상태 '매칭'으로 변경)(의뢰 히스토리 내역 입력)
		System.out.println("EnrollRequestAccept Controller result : " + result);  

		String path = "";
		if(result > 0) {
			//의뢰 매칭 성공
			RequestDTO requestDetail = requestService.selectRequestDetail(requestDto);  //매칭된 의뢰 상세 조회
			System.out.println("requestDetail : " + requestDetail);                   
			
			String phone = requestDetail.getPhone().getPhone();                      //의뢰등록한 사용자의 핸드폰 번호
			//testSend(phone);                                           //문자 발송
			
			if(requestDetail != null) {
				//의뢰 상세조회 성공
				path = "/WEB-INF/views/cleaner/requestDetails.jsp";               
				request.setAttribute("requestDetail", requestDetail);
			} else {
				//의뢰 상세조회 실패
				path = "/WEB-INF/views/common.failed.jsp";
				request.setAttribute("message", "의뢰 상세 조회 실패!");
			}
		} else {
			//의뢰 매칭 실패
			path = "/WEB-INF/views/common.failed.jsp";
			request.setAttribute("message", "의뢰 매칭 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}

	
	//문자발송 메소드
	public void testSend(String phone) { 
		String api_key = "NCSLL8QTEE8VM0FI"; //사이트에서 발급 받은 API KEY 
		String api_secret = "M6H3TRX1BWI86ADIDGTROWBH7AXWW71D"; //사이트에서 발급 받은 API SECRET KEY
		Message coolsms = new Message(api_key, api_secret); 
		HashMap<String, String> params = new HashMap<String, String>(); 
		params.put("to", phone);           //의뢰등록한 사용자의 핸드폰 번호
		params.put("from", "01064181281"); //사전에 사이트에서 번호를 인증하고 등록하여야 함
		params.put("type", "SMS"); 
		params.put("text", "고객님이 등록하신 의뢰가 매칭되었습니다. "); //메시지 내용
		params.put("mode", "test");
		try { 
			JSONObject obj = (JSONObject) coolsms.send(params); 
			System.out.println(obj.toString()); //전송 결과 출력
		} catch (CoolsmsException e) { 
			System.out.println(e.getMessage()); 
			System.out.println(e.getCode()); 
		} 
	}
}
