package com.pitcrew.cleanhome.admin.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.cleaner.request.model.dto.ProductDTO;

public class ProductDAO {

	public List<ProductDTO> selectAllProductList(SqlSession session) {
		return session.selectList("ProductDAO.selectAllProductList");
	}

}
