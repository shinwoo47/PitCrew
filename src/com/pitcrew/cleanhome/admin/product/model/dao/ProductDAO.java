package com.pitcrew.cleanhome.admin.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.ProductDTO;

public class ProductDAO {

	public List<ProductDTO> selectAllProductList(SqlSession session) {
		return session.selectList("ProductDAO.selectAllProductList");
	}

	public int insertProduct(SqlSession session, com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO newProduct) {

		return session.insert("ProductDAO.insertProduct", newProduct);
	}

	public int updateProduct(SqlSession session, com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO updateProduct) {
		System.out.println("박박박");
		return session.update("ProductDAO.updateProduct", updateProduct);
	}

}
