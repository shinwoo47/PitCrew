package com.pitcrew.cleanhome.admin.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.admin.report.model.service.ReportService;



@WebServlet("/admin/report/select")
public class SelectReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<ReportDTO> reportList = new ReportService().selectAllReportList();
		
		System.out.println("두겟 : " + reportList);
		
		String path = "";
        if(reportList != null) {
           path = "/WEB-INF/views/admin/report/reportList.jsp";
           request.setAttribute("reportList", reportList);
        } else {
           path = "/WEB-INF/views/common/failed.jsp";
           request.setAttribute("message", "신고 조회 실패!");
        }
        
        request.getRequestDispatcher(path).forward(request, response);
	}

}












