package com.pitcrew.cleanhome.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;



public class MemberDAO {
	
	/* MEMBER TABLE 신규 회원 insert용 메소드 */
	public int insertMember(SqlSession session, MemberDTO requestMember) {
		
		return session.insert("MemberDAO.insertMember", requestMember);
	}
	
	/* 암호화 처리 된 비밀번호 조회용 메소드(로그인 확인용) */
	public String selectEncryptedPwd(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectEncryptedPwd", requestMember);
	}
	
	/* 패스워드 일치 시 회원 정보 조회용 메소드 */
	public MemberDTO selectLoginMember(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectLoginMember", requestMember);
	}

	public int updateMember(SqlSession session, MemberDTO requestMember) {
		
		return 0;
	}

	public MemberDTO selectChangedMemberInfo(SqlSession session, int no) {
		
		return null;
	}

	public int deleteMember(SqlSession session, MemberDTO member) {
		
		return session.update("MemberDAO.deleteMember", member);
	}

	public int idCheck(SqlSession session, String id) {
		
		return session.selectOne("MemberDAO.idCheck", id);
	}

	public int registCleaner(SqlSession session, CleanerInfoDTO cleaner) {
		
		return session.insert("MemberDAO.registCleaner", cleaner);
	}

	public int selectMemNo(SqlSession session, String memberId) {
		
		return session.selectOne("MemberDAO.selectMemNo");
	}
	
	/* 폼에서 입력한 이름과 이메일이 일치하면 해당 아이디를 조회할 수 있는 메소드*/
	public MemberDTO selectMyId(SqlSession session, MemberDTO findMyId) {
		
		return session.selectOne("MemberDAO.selectMyId", findMyId);
	}
	
	/* 폼에서 입력한 아이디 이름과 이메일이 null값인지 조회하는 메소드*/
	public MemberDTO selectMyInfo(SqlSession session, MemberDTO setParameter) {

		return session.selectOne("MemberDAO.selectMyInfo", setParameter);
	}
	
	/* 재입력한 비밀번호를 업데이트 해주는 메소드 */
	public int updateMemberPwd(SqlSession session, MemberDTO updatePwd) {
		
		return session.update("MemberDAO.updateMemberPwd", updatePwd);
	}

	public CleanerInfoDTO identifyCheck(SqlSession session, MemberDTO loginMember) {
		
		return session.selectOne("MemberDAO.identifyCheck", loginMember);
	}

}
