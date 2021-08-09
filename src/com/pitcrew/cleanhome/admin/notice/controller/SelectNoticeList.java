package com.pitcrew.cleanhome.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.admin.notice.model.service.NoticeService;


@WebServlet("/admin/notice/list")
public class SelectNoticeList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList();
	}

}
