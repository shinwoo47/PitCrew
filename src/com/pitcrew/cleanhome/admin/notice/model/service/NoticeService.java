package com.pitcrew.cleanhome.admin.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import com.pitcrew.cleanhome.admin.notice.model.dao.NoticeDAO;
import com.pitcrew.cleanhome.admin.notice.model.dto.NoticeDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class NoticeService {

	private final NoticeDAO noticeDAO;

	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}

	/* 사용자, 관리자 공지사항 전체 목록 조회용 메소드 */
	public List<NoticeDTO> selectAllNoticeList(String forWho) {
		SqlSession session = getSqlSession();

		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(session, forWho);

		System.out.println("서비스 리턴값 체크 " + noticeList);
		session.close();

		return noticeList;
	}

	/* 공지 세부 */
	public NoticeDTO selectNoticeDetail(int no) {
		SqlSession session = getSqlSession();

		NoticeDTO noticeDTO = null;

		int result = noticeDAO.incrementNoticeCount(session, no);

		if(result > 0) {
			noticeDTO = noticeDAO.selectNoticeDetail(session, no);
			System.out.println("서비스 리턴값 체크 " + noticeDTO);

			if(noticeDTO != null) {
				session.commit();
			} else {
				session.rollback();
			} 

		} else {
			session.rollback();
		}
		session.close();

		return noticeDTO;
	}

	/* 관리자 회원번호 조회*/
	public int selectMemberNo() {
		
		SqlSession session = getSqlSession();
		
		int adminNo = noticeDAO.selectMemberNo(session);
		
		return adminNo;
	}
	
	
	/* 공지사항 등록 */
	public int insertNotice(NoticeDTO newNotice) {
		SqlSession session = getSqlSession();
		
		int result = noticeDAO.insertNotice(session, newNotice);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public List<NoticeDTO> selectAllFaqList(String forWho) {
		SqlSession session = getSqlSession();

		List<NoticeDTO> faqList = noticeDAO.selectAllFaqList(session, forWho);

		System.out.println("서비스 리턴값 체크 " + faqList);
		session.close();

		return faqList;
	}

	/* faq 세부 조회*/
	public NoticeDTO selectFaqDetail(int no) {
		SqlSession session = getSqlSession();

		NoticeDTO faqDTO = null;

		int result = noticeDAO.incrementNoticeCount(session, no);

		if(result > 0) {
			faqDTO = noticeDAO.selectNoticeDetail(session, no);
			System.out.println("서비스 리턴값 체크 " + faqDTO);

			if(faqDTO != null) {
				session.commit();
			} else {
				session.rollback();
			} 

		} else {
			session.rollback();
		}
		session.close();

		return faqDTO;
	}

	public int insertFaq(NoticeDTO newFaq) {
		SqlSession session = getSqlSession();

		int result = noticeDAO.insertFaq(session, newFaq);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	/* 1:1 문의사항 리스트 조회*/
	public List<NoticeDTO> selectAllPersonalList(String forWho) {
		
		SqlSession session = getSqlSession();

		List<NoticeDTO> personalList = noticeDAO.selectAllPersonalList(session, forWho);

		System.out.println("서비스 리턴값 체크 " + personalList);
		session.close();

		return personalList;
	}
	
	/* 1:1 문의사항 세부내역 */
	public NoticeDTO selectPersonalDetail(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	



}
