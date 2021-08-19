package com.pitcrew.cleanhome.admin.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.admin.report.model.service.ReportService;

@WebServlet("/admin/report/check")
public class CheckReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		
		System.out.println("신고 번호 : " + reportNo);
		
		ReportDTO reportDTO = new ReportService().checkReportDetail(reportNo);
		
	}

}
