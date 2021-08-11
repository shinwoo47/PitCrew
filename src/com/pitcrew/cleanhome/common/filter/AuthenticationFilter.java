package com.pitcrew.cleanhome.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.pitcrew.cleanhome.member.model.dto.MemberDTO;



@WebFilter(urlPatterns = {"/cleaner/*", "/user/*", "/admin/*", "/member/*"})
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println("intent : " + intent);
		
		/* 세션에 권한이 있는지 확인하여 허용된 url에만 접근 가능하도록 설정한다. */
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		
		boolean isAuthorized = false;
		if(loginMember != null) {
			
			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			boolean iscleanerPermitList = permitURIList.get("cleanerPermitList").contains(intent);
			System.out.println(loginMember.getRole());
			if("관리자".equals(loginMember.getRole())) {
				
				if(isPermitAdmin || isPermitMember || isPermitAll || iscleanerPermitList) {
					isAuthorized = true;
				}
				
			} else if("사용자".equals(loginMember.getRole())) {
				
				if((isPermitMember || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
				}
				
			} else if("해결사".equals(loginMember.getRole())) {
				System.out.println("hi");
				if((iscleanerPermitList || isPermitAll) && !isPermitAdmin) {
					isAuthorized = true;
					System.out.println(isAuthorized);
				}
				
			}
			
			if(isAuthorized) {
				chain.doFilter(request, response);
				
			} else {
				System.out.println(isAuthorized);
				((HttpServletResponse) response).sendError(403);
			}
			
		} else {
			
			if(permitURIList.get("allPermitList").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스 입니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(hrequest, response);
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		List<String> cleanerPermitList = new ArrayList<>();
		
		adminPermitList.add("/admin/home");
		adminPermitList.add("/admin/notice/list");
		adminPermitList.add("/admin/cleanernotice/list");
		adminPermitList.add("/admin/notice/detail");
		adminPermitList.add("/admin/cleanernotice/detail");
		adminPermitList.add("/admin/notice/insert");
		adminPermitList.add("/notice/update");

		adminPermitList.add("/admin/home");
		adminPermitList.add("/admin/select/alluserinfo");


		
		memberPermitList.add("/notice/list");
		memberPermitList.add("/notice/detail");
		memberPermitList.add("/board/list");
		memberPermitList.add("/board/insert");
		memberPermitList.add("/boart");
		memberPermitList.add("/thumbnaid/search");
		memberPermitList.add("/thumbnail/lisl/insert");
		memberPermitList.add("/thumbnail/detail");
		memberPermitList.add("/user/home");
		
		cleanerPermitList.add("/cleaner/request/enroll");
		cleanerPermitList.add("/cleaner/home");

		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
		permitURIList.put("cleanerPermitList", cleanerPermitList);
		
	}

}
