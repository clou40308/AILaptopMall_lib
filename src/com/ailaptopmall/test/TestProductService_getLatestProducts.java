package com.ailaptopmall.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.ProductService;

public class TestProductService_getLatestProducts {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			List<Product> list =pService.getLatestProducts();
			System.out.println(list);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		}

	}

}
