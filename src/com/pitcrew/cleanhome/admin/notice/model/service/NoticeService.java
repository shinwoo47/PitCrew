package com.pitcrew.cleanhome.admin.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import com.pitcrew.cleanhome.admin.notice.model.dao.NoticeDAO;
import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;

public class NoticeService {

	private final NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	/* 사용자, 관리자 공지사항 전체 목록 조회용 메소드 */
	public List<NoticeDTO> selectAllNoticeList() {
		SqlSession session = getSqlSession();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(session);

		session.close();

		return noticeList;
	}

}
