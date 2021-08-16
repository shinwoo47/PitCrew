package com.pitcrew.cleanhome.cleaner.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.notice.model.dto.NoticeDTO;

public class NoticeDAO {

	public List<NoticeDTO> selectNoticeList(SqlSession session, String category) {
		
		return session.selectList("NoticeDAO.selectNoticeList", category);
	}

	public NoticeDTO selectNoticeDetail(SqlSession session, int no) {
		
		return session.selectOne("NoticeDAO.selectNoticeDetail2", no);
	}

	public int insertQeustion(SqlSession session, NoticeDTO newNotice) {
		
		return session.insert("NoticeDAO.insertQeustion", newNotice);
	}

	public int updateQuestion(SqlSession session, NoticeDTO newNotice) {
		
		return session.update("NoticeDAO.updateQuestion", newNotice);
	}

	public int deleteQuestion(SqlSession session, int no) {
		
		return session.delete("NoticeDAO.deleteQuestion", no);
	}

}
