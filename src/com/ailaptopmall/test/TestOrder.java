package com.ailaptopmall.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ailaptopmall.entity.Customer;
import com.ailaptopmall.entity.Order;
import com.ailaptopmall.entity.PaymentType;
import com.ailaptopmall.entity.Product;
import com.ailaptopmall.entity.ShippingType;
import com.ailaptopmall.entity.ShoppingCart;
import com.ailaptopmall.entity.Spec;
import com.ailaptopmall.exception.AILMDataInvalidException;
import com.ailaptopmall.exception.AILMException;
import com.ailaptopmall.service.CustomerService;
import com.ailaptopmall.service.ProductService;

public class TestOrder {

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
				//System.out.println(cart);
			}
			
			//第二個測試
			{				
				cart.setMember(member);
				String productId="1"; 	//必要
				String sizeName="16";
				String specName="Ultra5";
				int quantity =1; 		//必要
				
				Product p = pService.getProductById(productId);
				Spec spec = null;
				if(p.getSpecCount()>0) {
					spec = pService.getTheSpec(productId, sizeName, specName); 
				}
				
				cart.addToCart(p, sizeName, spec, quantity);
				//System.out.println(cart);
			}
			
			//第三個測試
			{				
				cart.setMember(member);
				String productId="1"; 	//必要
				String sizeName="14";
				String specName="Ultra7";
				int quantity =1; 		//必要
				
				Product p = pService.getProductById(productId);
				Spec spec = null;
				if(p.getSpecCount()>0) {
					spec = pService.getTheSpec(productId, sizeName, specName); 
				}
				
				cart.addToCart(p, sizeName, spec, quantity);
				//System.out.println(cart);
			}
			
			//第四個測試
			{				
				cart.setMember(member);
				String productId="1"; 	//必要
				String sizeName="16";
				String specName="Ultra7";
				int quantity =1; 		//必要
				
				Product p = pService.getProductById(productId);
				Spec spec = null;
				if(p.getSpecCount()>0) {
					spec = pService.getTheSpec(productId, sizeName, specName); 
				}
				
				cart.addToCart(p, sizeName, spec, quantity);
				//System.out.println(cart);
			}
			
			
			String shippingType = "HOME";
			String paymemntType = "ATM";
			
			String name = member.getName();
			String email = member.getEmail();
			String phone = member.getPhone();
			String shippingAddress = member.getAddress();			
			
			ShippingType shType = ShippingType.valueOf(shippingType);
			PaymentType pType = PaymentType.valueOf(paymemntType);
			
			//建立訂單()
			Order order = new Order();
			order.setMember(cart.getMember());
			order.setCreatedDate(LocalDate.now());
			order.setCreatedTime(LocalTime.now());
			
			order.setShippingType(shType);
			order.setShippingFee(shType.getFee());
			
			order.setPaymentType(pType);
			order.setPaymentFee(pType.getFee());
			
			order.setRecipientName(name);
			order.setRecipientEmail(email);
			order.setRecipientPhone(phone);
			order.setShippingAddress(shippingAddress);
			order.add(cart);
			
			//oService.checkOut(order);
			
			System.out.println(order);	
		}catch(AILMDataInvalidException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (AILMException e) {
			Logger.getLogger("").log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			Logger.getLogger("").log(Level.SEVERE, "發生系統錯誤: "+e.getMessage(), e);
		}

	}

}
