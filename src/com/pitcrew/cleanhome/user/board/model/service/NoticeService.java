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

	public List<NoticeDTO> selectNoticeList(String category) {
		
		SqlSession session = getSqlSession();
		
		List<NoticeDTO> noticeList = noticeDAO.selectNoticeList(session, category);
		System.out.println("mapper성공");
		session.close();
		
		return noticeList;
	}
	
	public NoticeDTO selectNoticeDetail(int no) {
		
		SqlSession session = getSqlSession();
		
		NoticeDTO noticeDetail = noticeDAO.selectNoticeDetail(session, no);
		
		session.close();
		
		return noticeDetail;
	}

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
