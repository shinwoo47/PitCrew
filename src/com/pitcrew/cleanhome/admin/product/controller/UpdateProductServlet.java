package com.pitcrew.cleanhome.admin.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO;
import com.pitcrew.cleanhome.admin.product.model.service.ProductService;

@WebServlet("/admin/product/update")
public class UpdateProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/admin/product/updateForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int serNo = Integer.parseInt(request.getParameter("serNo"));
		String serCategory = request.getParameter("serCategory");
		String serName = request.getParameter("serName");
		String serContent = request.getParameter("serContent");
		double serTime = Double.parseDouble(request.getParameter("serTime"));
		int serPrice = Integer.parseInt(request.getParameter("serPrice"));
		
		ProductDTO updateProduct = new ProductDTO();
		updateProduct.setSerNo(serNo);
		updateProduct.setSerCategory(serCategory);
		updateProduct.setSerName(serName);
		updateProduct.setSerContent(serContent);
		updateProduct.setSerTime(serTime);
		updateProduct.setSerPrice(serPrice);
		
		ProductService productService = new ProductService();
		
		int result = productService.updateProduct(updateProduct);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateProduct");				
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 수정에 실패하셨습니다.");
		}
	
		request.getRequestDispatcher(path).forward(request, response);
	}

}
