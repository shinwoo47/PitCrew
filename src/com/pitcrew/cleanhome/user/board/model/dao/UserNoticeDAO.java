package com.pitcrew.cleanhome.user.board.model.dao;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;

public class UserNoticeDAO {

	public List<NoticeDTO> selectNoticeList(SqlSession session, String category) {
		
		return session.selectList("UserNoticeDAO.selectNoticeList3", category);
	}

	public NoticeDTO selectNoticeDetail(SqlSession session, int no) {
		
		return session.selectOne("UserNoticeDAO.selectNoticeDetail3", no);
	}

	public int insertQeustion(SqlSession session, NoticeDTO newNotice) {
		
		return session.insert("UserNoticeDAO.insertQeustion", newNotice);
	}

	public int updateQuestion(SqlSession session, NoticeDTO newNotice) {
		
		return session.update("UserNoticeDAO.updateQuestion", newNotice);
	}

	public int deleteQuestion(SqlSession session, int no) {
		
		return session.delete("UserNoticeDAO.deleteQuestion", no);
	}

}
