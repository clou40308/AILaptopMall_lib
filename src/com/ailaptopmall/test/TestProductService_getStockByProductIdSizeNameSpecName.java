package com.ailaptopmall.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.ProductService;

public class TestProductService_getStockByProductIdSizeNameSpecName {
	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			 int stock = pService.getStockByProductIdSizeNameSpecName(1,"14","Ultra5");
			
			System.out.println(stock);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e);
			System.out.println(e + ", 請聯絡Admin");
		}
	}
}
