package com.pitcrew.cleanhome.member.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pitcrew.cleanhome.member.model.dao.MemberDAO;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;

public class MemberService {
	
	/* 의존 관계에 있는 객체가 불변을 유지할 수 있도록 final 필드로 선언한다. */
	private final MemberDAO memberDAO;
	
	/* 생성자를 이용하여 객체를 생성하여 필드에 값을 넣는다. */
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	/* 회원 가입용 메소드 */
	public int registMember(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		
		int result = memberDAO.insertMember(session, requestMember);
		
		if((requestMember.getRole()).equals("해결사")) {
			
			int memNo = memberDAO.selectMemNo(session, requestMember.getId());
			
			CleanerInfoDTO cleaner = new CleanerInfoDTO();
			cleaner.setEducateYn("N");
			cleaner.setIdentifyYn("N");
			cleaner.setMemNo(memNo);
			int result2 = memberDAO.registCleaner(session, cleaner);
			if(result2 > 0) {
				result = 1;
			} else {
				result = 0;
			}
		}
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	/* 로그인 처리용 메소드 */
	public MemberDTO loginCheck(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		MemberDTO loginMember = null;
		
		String encPwd = memberDAO.selectEncryptedPwd(session, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 로그인 요청한 원문 비밀번호화 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. */
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			/* 비밀번호가 일치하는 경우에만 회원 정보를 조회해온다. */
			loginMember = memberDAO.selectLoginMember(session, requestMember);
		}
		
		session.close();
		
		return loginMember;
		
	}

	public MemberDTO modifyMember(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		MemberDTO changedMemberInfo = null;
		
		int result = memberDAO.updateMember(session, requestMember);
		
		if(result > 0) {
			session.commit();
			changedMemberInfo = memberDAO.selectChangedMemberInfo(session, requestMember.getMemNo());
		} else {
			session.rollback();
		}
		
		session.close();
		
		return changedMemberInfo;
	}

	public int removeMember(MemberDTO requestMember) {
		
		SqlSession session = getSqlSession();
		
		int result = memberDAO.deleteMember(session, requestMember);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int idCheck(String id) {
		
		SqlSession session = getSqlSession();
		
		int idCount = memberDAO.idCheck(session, id);
				
		session.close();
		
		return idCount;
	}

	public int registCleaner(CleanerInfoDTO cleaner, String memberId) {
		
		SqlSession session = getSqlSession();
		
		
		
		int result = memberDAO.registCleaner(session, cleaner);
		
		session.close();
		
		return result;
	}

	public int deleteMember(MemberDTO member) {
		
		SqlSession session = getSqlSession();
		
		int result = memberDAO.deleteMember(session, member);
		return 0;
	}

	public MemberDTO selectMyId(MemberDTO findMyId) {
		
		SqlSession session = getSqlSession();
		
		MemberDTO selectMyId = memberDAO.selectMyId(session, findMyId);
		
		session.close();
		
		return selectMyId;
	}

	public MemberDTO selectMyPwd(MemberDTO setParameter) {

		SqlSession session = getSqlSession();
		
		MemberDTO selectMyInfo = memberDAO.selectMyInfo(session, setParameter);
		
		session.close();
		
		return selectMyInfo;
	}

	public int updateMemberPwd(MemberDTO updatePwd) {
		
		SqlSession session = getSqlSession();
		
		int result = memberDAO.updateMemberPwd(session, updatePwd);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public CleanerInfoDTO identifyCheck(MemberDTO loginMember) {
		
		SqlSession session = getSqlSession();
		
		CleanerInfoDTO cleaner = memberDAO.identifyCheck(session, loginMember);
		
		session.close();
		
		return cleaner;
	}

}
