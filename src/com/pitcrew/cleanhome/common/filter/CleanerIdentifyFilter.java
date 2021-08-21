package com.pitcrew.cleanhome.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pitcrew.cleanhome.member.model.dto.CleanerInfoDTO;


@WebFilter(urlPatterns = {"/cleaner/request/*"})
public class CleanerIdentifyFilter implements Filter {

   
	public void destroy() {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession requestSession = hrequest.getSession();
		CleanerInfoDTO cleaner = (CleanerInfoDTO) requestSession.getAttribute("cleanerInfo");
		
		boolean isAuthorized = false;
		if(cleaner.getIdentifyYn().equals("Y") && cleaner.getEducateYn().equals("Y")) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendError(403);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
