package com.pitcrew.cleanhome.admin.request.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectCriteria;

public class RequestDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("RequestDAO.selectTotalCount", searchMap);
	}

	public List<RequestDTO> selectRequestList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("RequestDAO.selectBoardList", selectCriteria);
	}

}
