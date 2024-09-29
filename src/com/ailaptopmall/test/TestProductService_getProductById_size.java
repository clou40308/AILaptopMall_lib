package com.ailaptopmall.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Product;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.ProductService;

public class TestProductService_getProductById_size {
	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			Product p = pService.getProductById("1");
			
			System.out.println(p.getSizeList());
			p.getSizeList().clear();
			System.out.println(p);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e);
			System.out.println(e + ", 請聯絡Admin");
		}
	}
}
