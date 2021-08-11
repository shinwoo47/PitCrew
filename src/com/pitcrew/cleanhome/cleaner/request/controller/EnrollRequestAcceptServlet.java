package com.pitcrew.cleanhome.cleaner.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.model.service.RequestService;

@WebServlet("/cleaner/request/accept")
public class EnrollRequestAcceptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));                 //의뢰 번호
		String status = request.getParameter("status");                        //의뢰 상태

		RequestDTO requestDto = new RequestDTO();
		requestDto.setReqNo(no);
		requestDto.setReqStatus(status);

		System.out.println(status);
		System.out.println("reqNo : " + no);

		RequestService requestService = new RequestService();

		int result = requestService.acceptRequest(requestDto);                           //의뢰 매칭(의뢰 상태 '매칭'으로 변경)
		System.out.println("EnrollRequestAccept Controller result : " + result);

		String path = "";
		if(result > 0) {
			//의뢰 매칭 성공
			status = requestService.selectRequestStatus(requestDto);                     //의뢰 상태 조회
			requestDto.setReqStatus(status);
			RequestDTO requestDetail = requestService.selectRequestDetail(requestDto);  //매칭된 의뢰 상세 조회
			System.out.println("requestDetail : " + requestDetail);
			int result2 = requestService.insertRequestStatusHistory(requestDto);        //의뢰 상태 히스토리에 매칭상태일자 등록
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
