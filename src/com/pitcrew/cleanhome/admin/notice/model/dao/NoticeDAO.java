package com.pitcrew.cleanhome.admin.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;

public class NoticeDAO {


	public List<NoticeDTO> selectAllNoticeList(SqlSession session, String forWho) {


		return session.selectList("NoticeDAO.selectAllNoticeList", forWho);
	}

	public int incrementNoticeCount(SqlSession session, int no) {

		return session.update("NoticeDAO.incrementNoticeCount", no);
	}


	public NoticeDTO selectNoticeDetail(SqlSession session, int no) {


		return session.selectOne("NoticeDAO.selectNoticeDetail", no);

	}

	/* 관리자 회원번호 조회 */
	public int selectMemberNo(SqlSession session) {
		
		return session.selectOne("NoticeDAO.selectMemberNo");
	}
	
	
	public int insertNotice(SqlSession session, NoticeDTO newNotice) {
		
		
		return session.insert("NoticeDAO.insertNotice", newNotice);
	}

	



}
