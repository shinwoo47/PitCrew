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
	public List<NoticeDTO> selectAllNoticeList(String forWho) {
		SqlSession session = getSqlSession();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(session, forWho);

		System.out.println("서비스 리턴값 체크 " + noticeList);
		session.close();

		return noticeList;
	}

	public NoticeDTO selectNoticeDetail(int no) {
		SqlSession session = getSqlSession();

		NoticeDTO noticeDTO = null;

		int result = noticeDAO.incrementNoticeCount(session, no);

		if(result > 0) {
			noticeDTO = noticeDAO.selectNoticeDetail(session, no);
			System.out.println("서비스 리턴값 체크 " + noticeDTO);

			if(noticeDTO != null) {
				session.commit();
			} else {
				session.rollback();
			} 

		} else {
			session.rollback();
		}
		session.close();

		return noticeDTO;
	}
	
	
	
}
