package com.pitcrew.cleanhome.admin.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.pay.model.dto.PayListDTO;
import com.pitcrew.cleanhome.admin.pay.model.service.PayListService;

@WebServlet("/admin/paylist/select")
public class SelectPayList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PayListDTO> payList = new PayListService().selectAllPayList();
		
		String path = "";
        if(payList != null) {
           path = "/WEB-INF/views/admin/pay/payList.jsp";
           request.setAttribute("payList", payList);
        } else {
           path = "/WEB-INF/views/common/failed.jsp";
           request.setAttribute("message", "블랙리스트 조회 실패!");
        }
        
        request.getRequestDispatcher(path).forward(request, response);
	
	}

}
