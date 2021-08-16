package com.pitcrew.cleanhome.admin.product.model.service;

import static com.pitcrew.cleanhome.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pitcrew.cleanhome.admin.product.model.dao.ProductDAO;
import com.pitcrew.cleanhome.cleaner.request.model.dto.ProductDTO;

public class ProductService {

	private final ProductDAO productDAO;

	public ProductService() {
		productDAO = new ProductDAO();
	}

	public List<ProductDTO> selectAllProductList() {

		SqlSession session = getSqlSession();

		List<ProductDTO> productList = productDAO.selectAllProductList(session);

		session.close();

		return productList;
	}

	public int insertProduct(com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO newProduct) {
		SqlSession session = getSqlSession();
		
		int result = productDAO.insertProduct(session, newProduct);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public int updateProduct(com.pitcrew.cleanhome.admin.product.model.dto.ProductDTO updateProduct) {

		SqlSession session = getSqlSession();
		
		int result = productDAO.updateProduct(session, updateProduct);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}




}
