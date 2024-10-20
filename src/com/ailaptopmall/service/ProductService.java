package com.ailaptopmall.service;

import java.util.List;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.entity.Spec;
import com.ailaptopmall.exception.AILMDataInvalidException;
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

	public List<Product> getProductsByMaker(String maker) throws AILMException {
		if (maker == null || maker.length() == 0)
			throw new IllegalArgumentException("[廠牌查詢]maker不得為null或空字串");

		return dao.selectProductsByMaker(maker);
	}

	public List<Product> getLatestProducts() throws AILMException {
		return dao.selectLatestProducts();
	}

	public Product getProductById(String id) throws AILMException {
		if (id == null || id.length() == 0)
			throw new IllegalArgumentException("[用id查詢產品]id不得為null或空字串");

		return dao.selectProductById(id);
	}

	public List<Spec> getProductSpecsByIdAndSizeName(String productId, String sizeName) throws AILMException {
		if (productId == null || productId.length() == 0)
			throw new IllegalArgumentException("查詢[指定產品-螢幕尺寸]的specList時，productId必須有值");
		return dao.selectProductSpecsByIdAndSizeName(productId, sizeName);
	}
	
	public Spec getTheSpec(String productId, String sizeName, String specName)throws AILMException {
		if(productId==null || productId.length()==0)
			  throw new IllegalArgumentException("查詢[指定產品-螢幕尺寸-規格]時，productId必須有值");
		
		if(specName==null || specName.length()==0)
			  throw new IllegalArgumentException("查詢[指定產品-螢幕尺寸-規格]時，specName必須有值");
		
		if(sizeName==null) sizeName="";
		
		Spec theSpec = null;
		
		List<Spec> list = 
				dao.selectProductSpecsByIdAndSizeName(productId, sizeName);
		if(list!=null && list.size()>0) {
			for(int i=0;i<list.size();i++) {
				Spec spec = list.get(i);
				if(specName.equals(spec.getSpecName())) {
					theSpec = spec;
					break;
				}
			}
		}
		
		if(theSpec==null) {
			String errMsg = 
				String.format("找不到指定的規格: %s-%s-%s", productId, sizeName,specName );
			throw new AILMDataInvalidException(errMsg);
		}
		return theSpec;
	}
	
	//取5個亂數的產品
	public List<Product> getRandomProducts() throws AILMException {
		return dao.selectRandomProducts();
	}
	
	//TODO:提供[即時庫存查詢的]商業邏輯 
	public int getStockByProductIdSizeNameSpecName(int productId, String sizeName, String specName) throws AILMException {
	       if(productId<=0) throw new IllegalArgumentException("查詢庫存必須有productId");
	       if(sizeName==null) sizeName = "";
	       if(specName==null) specName = "";

	       return dao.selectStockByProductIdSizeNameSpecName(productId, sizeName, specName);
	 }	
}
