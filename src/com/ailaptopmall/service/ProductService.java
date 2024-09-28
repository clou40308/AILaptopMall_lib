package com.ailaptopmall.service;

import java.util.List;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.exception.AILMException;

public class ProductService {
	private ProductsDAO dao = new ProductsDAO();

	public List<Product> getAllProducts() throws AILMException {
		return dao.selectAllProducts();
	}

	public List<Product> getProductsByKeyword(String keyword) throws AILMException {
		if (keyword == null || keyword.length() == 0)
			throw new IllegalArgumentException("關鍵字查詢不得為null或空字串");

		return dao.selectProductsByKeyword(keyword);
	}
	
	public List<Product> getProductsByMaker(String maker) throws AILMException{
		if(maker==null || maker.length()==0) 
			throw new IllegalArgumentException("[廠牌查詢]maker不得為null或空字串");
		
		return dao.selectProductsByMaker(maker);
	}
	
	public List<Product> getLatestProducts() throws AILMException{
		return dao.selectLatestProducts();
	}
	
	public Product getProductById(String id) throws AILMException{
		if(id==null || id.length()==0) 
			throw new IllegalArgumentException("[用id查詢產品]id不得為null或空字串");
		
		return dao.selectProductById(id);
	}
}
