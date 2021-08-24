package com.pitcrew.cleanhome.user.board.model.dao;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.user.board.model.dto.NoticeDTO;

public class UserNoticeDAO {
	
	/* 게시글 목록 불러오기 메소드 */
	public List<NoticeDTO> selectNoticeList(SqlSession session, String category) {
		
		return session.selectList("UserNoticeDAO.selectNoticeList", category);
	}

	/* 게시글 세부 내용 불러오기 메소드 */
	public NoticeDTO selectNoticeDetail(SqlSession session, int no) {
		
		return session.selectOne("UserNoticeDAO.selectNoticeDetail", no);
	}
	
	/* 게시글 등록 메소드 */
	public int insertQeustion(SqlSession session, NoticeDTO newNotice) {
		
		return session.insert("UserNoticeDAO.insertQeustion", newNotice);
	}

	/* 게시글 업데이트 메소드 */
	public int updateQuestion(SqlSession session, NoticeDTO newNotice) {
		
		return session.update("UserNoticeDAO.updateQuestion", newNotice);
	}

	/* 게시글 삭제 메소드 */
	public int deleteQuestion(SqlSession session, int no) {
		
		return session.delete("UserNoticeDAO.deleteQuestion", no);
	}

}
