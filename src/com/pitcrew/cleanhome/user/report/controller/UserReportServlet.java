package com.pitcrew.cleanhome.user.report.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportAttachmentDTO;
import com.pitcrew.cleanhome.cleaner.report.model.dto.ReportDTO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.RequestDTO;
import com.pitcrew.cleanhome.member.model.dto.MemberDTO;
import com.pitcrew.cleanhome.user.report.model.service.UserReportService;

@WebServlet("/user/request/report")
public class UserReportServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reqNo = Integer.parseInt(request.getParameter("no"));
		
		String path = "";
		path = "/WEB-INF/views/user/request/userReportRequest.jsp";
		request.setAttribute("reqNo", reqNo);
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO) session.getAttribute("loginMember");
			int memNo = member.getMemNo();
			String memName = member.getMemName();
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			
			String fileUploadDirectory = rootLocation + "/resources/upload/report/" + memName + "/";   
			
			/* 파일 저장경로가 존재하지 않는 경우 디렉토리를 생성한다. */
			File directory = new File(fileUploadDirectory);
			
			if(!directory.exists()) {
				/* 폴더를 한 개만 생성할거면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 생성하란 의미로 mkdirs를 이용한다. */
				System.out.println("폴더 생성 : " + directory.mkdirs());
			}
			
			/* 이게 최종적으로 request를 parsing하고 파일을 저장한 뒤 필요한 내용을 담을 리스트와 맵이다.
			 * 파일에 대한 정보는 리스트에, 다른 파라미터의 정보는 모두 맵에 담을 것이다.
			 * */
			
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			/* 파일을 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스이다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	        fileItemFactory.setRepository(new File(fileUploadDirectory));
	        fileItemFactory.setSizeThreshold(maxFileSize);
	        
	        /* 서블릿에서 기본 제공하는거 말고 꼭 commons fileupload 라이브러이에 있는 클래스로 임포트 해야 한다. */
	        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
	        
	        
	        try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					System.out.println(item);
				}
				
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					System.out.println(item);
					
					if(!item.isFormField()) {
						/* 파일 데이터인 경우*/
						
						if(item.getSize() > 0) {
							String fieldName = item.getFieldName();
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");//.위치를 찾아서 인덱스 위치 반환
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext; //문자열이 아니여서 toString()으로 문자열 반환
							
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							/*저장한다.*/
							item.write(storeFile);
							
							/* DB에 저장하기 위해 필요한 정보를 Map에 담는다. */
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);

							fileList.add(fileMap);
						} else {
							/* 폼데이터인 경우 */
							parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						}
					}
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
				int reqNo = Integer.parseInt(parameter.get("reqNo"));
				System.out.println(reqNo);
//				int reportCategoryCode = Integer.parseInt(parameter.get("reportCategory"));
//				String body = parameter.get("body");
//				
//				UserReportService userReq = new UserReportService();
//				RequestDTO req = userReq.selectCleanerNo(reqNo);
//				
//				System.out.println("req : " + req);
//				
//				ReportDTO report = new ReportDTO();
//				report.setReportCategoryCode(reportCategoryCode);
//				report.setMemNoReporter(memNo);
//				report.setMemNoSucpect(req.getMemNoCleaner());
//				report.setReportBody(body);
//				report.setReqNo(reqNo);
//				
//				List<ReportAttachmentDTO> reportAttachmentList = new ArrayList<>();
//				for(int i = 0; i < fileList.size(); i++) {
//					Map<String, String> file = fileList.get(i);
//					
//					ReportAttachmentDTO tempFileInfo = new ReportAttachmentDTO();
//					tempFileInfo.setOriginalName(file.get("originFileName"));
//					tempFileInfo.setSavedName(file.get("savedFileName"));
//					tempFileInfo.setSavePath(file.get("savePath"));
//					tempFileInfo.setAttachCategory("사진");
//					
//					reportAttachmentList.add(tempFileInfo);
//			
//				}		
//					
//				
//				String path ="";
				
	        } catch (Exception e) {
				e.printStackTrace();
			}
	        
		}
	}

}
