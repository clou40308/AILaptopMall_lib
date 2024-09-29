package com.ailaptopmall.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Spec;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.ProductService;

public class TestProductService_getProductSpecsByIdAndSizeName {

	public static void main(String[] args) {
		ProductService pService = new ProductService();
		
		try {
			List<Spec> list = pService.getProductSpecsByIdAndSizeName("1", "14");
			
			System.out.println(list);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(),e);
			System.out.println(e + ", 請聯絡Admin");
		}

	}

}
