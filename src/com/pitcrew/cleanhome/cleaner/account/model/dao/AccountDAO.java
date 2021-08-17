package com.pitcrew.cleanhome.cleaner.account.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.account.model.dto.AccountDTO;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;

public class AccountDAO {

	public CleanerInfoDTO selectCleanerInfo(SqlSession session, int memNo) {
		
		return session.selectOne("AccountDAO.selectCleanerInfo", memNo);
	}

	public int updateAccount(SqlSession session, CleanerInfoDTO account) {
		
		return session.update("AccountDAO.updateAccount", account);
	}

	public int insertAccountHistory(SqlSession session, AccountDTO accountHistory) {
		
		return session.insert("AccountDAO.insertAccountHistory", accountHistory);
	}

	public int insertAccount(SqlSession session, CleanerInfoDTO account) {
		
		return session.insert("AccountDAO.insertAccount", account);
	}

}
