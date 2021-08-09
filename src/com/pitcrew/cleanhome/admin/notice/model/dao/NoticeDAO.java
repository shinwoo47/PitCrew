package com.pitcrew.cleanhome.admin.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;

public class NoticeDAO {

	public List<NoticeDTO> selectAllNoticeList(SqlSession session) {
		
		return session.selectList("NoticeDAO.selectAllNoticeList");
	}

}
