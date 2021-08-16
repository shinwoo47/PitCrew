package com.pitcrew.cleanhome.cleaner.request.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dao.RequestDAO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.FullCalendarDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.cleaner.request.paging.SelectCriteria;


public class RequestService {
	
	private final RequestDAO requestDAO;
	
	/* 생성자를 이용하여 객체를 생성하여 필드에 값을 넣는다. */
	public RequestService() {
		requestDAO = new RequestDAO();
	}

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = requestDAO.selectTotalCount(session, searchMap);
		
		session.close();
		
		return totalCount;
	}

	public List<RequestDTO> selectRequestList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<RequestDTO> requestList = requestDAO.selectRequestList(session, selectCriteria);
		
		session.close();
		
		return requestList;
	}

	public int acceptRequest(RequestDTO requestDto) {
		
		SqlSession session = getSqlSession();
		
		int result = requestDAO.acceptRequest(session, requestDto);

		int result2 = requestDAO.insertRequestStatusHistory(session, requestDto);
	
		int resultCheck = 0;
		if(result > 0 && result2 > 0) {
			resultCheck = 1;
		}
		if(resultCheck > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return resultCheck;
	}

	public RequestDTO selectRequestDetail(RequestDTO requestDto) {
		
		SqlSession session = getSqlSession();
		
		String status = requestDAO.selectRequestStatus(session, requestDto);
		requestDto.setReqStatus(status);
		
		RequestDTO requestDetail = requestDAO.selectRequestDetail(session, requestDto);
		
		session.close();
		
		return requestDetail;
	}

	public int selectCleanerTotalCount(Map<String, Object> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = requestDAO.selectCleanerTotalCount(session, searchMap);
		
		return totalCount;
	}

	public List<RequestDTO> selectCleanerRequestList(Map<String, Object> searchMap) {
		
		SqlSession session = getSqlSession();
		
		List<RequestDTO> requestList = requestDAO.selectCleanerRequestList(session, searchMap);
		
		return requestList;
	}

	public List<FullCalendarDTO> selectCalendar(Map<String, Object> searchMap) {
		
		SqlSession session = getSqlSession();
		
		List<FullCalendarDTO> calendarList = requestDAO.selectCalendar(session, searchMap);
		
		session.close();
		
		return calendarList;
	}

	public int completeRequest(RequestDTO requestDto) {
		
		SqlSession session = getSqlSession();
		
		int result = requestDAO.completeRequest(session, requestDto);  //의뢰 완료상태로 변경

		int result2 = requestDAO.insertRequestStatusHistory(session, requestDto);  //의뢰 상태변경 히스토리에 기록
	
		int resultCheck = 0;
		if(result > 0 && result2 > 0) {
			resultCheck = 1;
		}
		if(resultCheck > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return resultCheck;
	}

	


}
