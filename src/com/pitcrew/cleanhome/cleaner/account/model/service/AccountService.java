package com.pitcrew.cleanhome.cleaner.account.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.account.model.dao.AccountDAO;
import com.pitcrew.cleanhome.cleaner.account.model.dto.AccountDTO;
import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}

	public CleanerInfoDTO selectCleanerInfo(int memNo) {
	
		SqlSession session = getSqlSession();
		
		CleanerInfoDTO cleanerInfo = accountDAO.selectCleanerInfo(session, memNo);
		
		session.close();
		
		return cleanerInfo;
	}

	public int updateAccount(CleanerInfoDTO account, AccountDTO accountHistory) {

		SqlSession session = getSqlSession();
		
		int result = accountDAO.updateAccount(session, account);
		
		int result2 = accountDAO.insertAccountHistory(session, accountHistory);
		
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
