package com.ailaptopmall.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Product;
import com.ailaptopmall.entity.ShoppingCart;
import com.ailaptopmall.entity.Spec;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.CustomerService;
import com.ailaptopmall.service.ProductService;

public class TestShoppingCart {

	public static void main(String[] args) {
		CustomerService cService = new CustomerService();
		ProductService pService = new ProductService();
		
		try {
			Customer member = cService.login("clou40308", "a123456");
			ShoppingCart cart = new ShoppingCart();
			cart.setMember(member);
			
			//第一個測試
			{				
				cart.setMember(member);
				String productId="1"; 	//必要
				String sizeName="14";
				String specName="Ultra5";
				int quantity =1; 		//必要
				
				Product p = pService.getProductById(productId);
				Spec spec = null;
				if(p.getSpecCount()>0) {
					spec = pService.getTheSpec(productId, sizeName, specName); 
				}
				
				cart.addToCart(p, sizeName, spec, quantity);
				System.out.println(cart);
			}
			
		}catch(AILMDataInvalidException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生系統錯誤: "+e.getMessage(), e);
		}

	}

}
