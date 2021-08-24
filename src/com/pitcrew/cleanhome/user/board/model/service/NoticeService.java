package com.pitcrew.cleanhome.user.board.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession; 

import java.util.List;

import org.apache.ibatis.session.SqlSession; 

import com.pitcrew.cleanhome.user.board.model.dao.UserNoticeDAO;
import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;


public class NoticeService {
	
	private  UserNoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new UserNoticeDAO();
	}
	
	/* 게시글 목록 불러오기 메소드 */
	public List<NoticeDTO> selectNoticeList(String category) {
		
		SqlSession session = getSqlSession();
		
		List<NoticeDTO> noticeList = noticeDAO.selectNoticeList(session, category);
		
		session.close();
		
		return noticeList;
	}
	
	/* 게시글 세부 내용 불러오기 메소드 */
	public NoticeDTO selectNoticeDetail(int no) {
		
		SqlSession session = getSqlSession();
		
		NoticeDTO noticeDetail = noticeDAO.selectNoticeDetail(session, no);
		
		session.close();
		
		return noticeDetail;
	}
	
	/* 게시글 등록 메소드 */
	public int insertQeustion(NoticeDTO newNotice) {
		
		SqlSession session = getSqlSession();

		int result = noticeDAO.insertQeustion(session, newNotice);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	/* 게시글 업데이트 메소드 */
	public int updateQuestion(NoticeDTO newNotice) {

		SqlSession session = getSqlSession();

		int result = noticeDAO.updateQuestion(session, newNotice);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}
	
	/* 게시글 삭제 메소드 */
	public int deleteNotice(int no) {
		
		SqlSession session = getSqlSession();

		int result = noticeDAO.deleteQuestion(session, no);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

}
