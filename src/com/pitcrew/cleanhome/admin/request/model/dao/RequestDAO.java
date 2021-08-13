package com.pitcrew.cleanhome.admin.request.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.common.paging.SelectCriteria;

public class RequestDAO {

	public int selectAllCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("RequestDAO.selectAllCount", searchMap);
	}

	public List<RequestDTO> selectReqList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("RequestDAO.selectReqList", selectCriteria);
	}

}
