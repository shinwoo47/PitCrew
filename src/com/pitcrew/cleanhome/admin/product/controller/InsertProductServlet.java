package com.pitcrew.cleanhome.admin.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO;
import com.pitcrew.cleanhome.admin.product.model.service.ProductService;

@WebServlet("/admin/product/Insert")
public class InsertProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/admin/product/insertForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int serNo = Integer.parseInt(request.getParameter("serNo"));
		String serCategory = request.getParameter("serCategory");
		String serName = request.getParameter("serName");
		int serPrice = Integer.parseInt(request.getParameter("serPrice"));
		
		ProductDTO newProduct = new ProductDTO();
		newProduct.setSerName(serName);
		newProduct.setSerCategory(serCategory);
		newProduct.setSerName(serName);
		newProduct.setSerPrice(serPrice);
		
		ProductService productService = new ProductService();
		
		int result = productService.insertProduct(newProduct);
	
	}

}
