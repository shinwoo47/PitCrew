package com.pitcrew.cleanhome.admin.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.product.model.service.ProductService;
import com.pitcrew.cleanhome.cleaner.request.model.dto.ProductDTO;

@WebServlet("/admin/product/list")
public class SelectProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<ProductDTO> productList = new ProductService().selectAllProductList();
		
		String path = "";
		if(productList != null) {
			path = "/WEB-INF/views/admin/product/productList.jsp";
			request.setAttribute("productList", productList);
		} else {
			path = "/WEB-INF/common/failed.jsp";
			request.setAttribute("message", "조회에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}











