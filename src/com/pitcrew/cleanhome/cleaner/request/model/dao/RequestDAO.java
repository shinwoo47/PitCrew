package com.pitcrew.cleanhome.cleaner.request.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class RequestDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("SelectTotalcount.RequestDAO", searchMap);
	}

}
