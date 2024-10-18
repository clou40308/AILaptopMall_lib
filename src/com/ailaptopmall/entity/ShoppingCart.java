package com.ailaptopmall.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ailaptopmall.exception.AILMDataInvalidException;

public class ShoppingCart {
	private Customer member;
	private Map<CartItem,Integer> cart = new HashMap<>();
	
	public Customer getMember() {
		return member;
	}
	public void setMember(Customer member) {
		this.member = member;
	}
	
	//取代 cart屬性的setter的方法: add, update, remove
	public void addToCart(Product p, String sizeName, Spec spec, int quantity)  {
		if(p ==null) throw new IllegalArgumentException("加入購物車時產品p不得為null");
		
		Size theSize = null;		
		if(p.getSizeList().size()>0 && sizeName!=null) {			
			theSize = p.findSize(sizeName);			
		}
		
		if(p.getSizeList().size()>0 && theSize==null) {
			throw new AILMDataInvalidException("加入購物車螢幕尺寸不正確");
		}
		
		CartItem item = new CartItem();
		item.setTheProduct(p);
		item.setTheSize(theSize);
		item.setTheSpec(spec);
		
		Integer prevQty = cart.get(item);//檢查同一個item是否已經有之前的購買數量
		if(prevQty!=null) quantity += prevQty;
		
		cart.put(item, quantity); //將購買明細與數量加入購物車
	}	

	public void update(CartItem item, int quantity) {
		Integer prevQty = cart.get(item);//檢查同一個item是否已經有之前的購買數量
		if(prevQty!=null) cart.put(item, quantity);
	}
	
	public Integer remove(CartItem item) {
		return cart.remove(item);
	}
	
	//取代 cart屬性的getter的方法:	
	//用[source]->[delegate methods]
	public int size() { //共N項
		return cart.size();
	}
	
	public boolean isEmpty() {
		return cart.isEmpty();
	}
	
	public Integer getQuantity(CartItem key) {
		return cart.get(key);
	}
	
	public Set<CartItem> getCartItemsSet() {
		//集合不得回傳正本(刪除集合元素時，可能發生java.util.ConcurrentModificationException)
		return new HashSet<>(cart.keySet()); // 改成回傳副本
	}
	
	//自訂getter(依據商業邏輯)
	public double getAmount(CartItem key) {
		Integer qty = this.getQuantity(key);
		
		double amount = 0;
		if(qty!=null) amount = key.getPrice() * qty;
		
		return amount;		
	}
	
	public int getTotalQuantity() { //共N件
		int sum = 0;
		Collection<Integer> values= cart.values();
		for(Integer qty:values) {
			if(qty!=null)sum = sum + qty;
		}		
		return sum;
	}
	
	/**	 
	 * @return 購物車的總金額
	 */
	public double getTotalAmount() { //總金額
		double sum = 0;
		Set <CartItem> keySet = cart.keySet();
		for(CartItem item:keySet) {
			sum = sum + getAmount(item);
		}		
		return Math.round(sum); //回傳前用Math.round(sum)、Math.floor(sum)、Math.ceil(sum)來處理小數資料
	}
	
	public String getCartProduct() { 
	    StringBuilder nameBuilder = new StringBuilder();
	    Set<CartItem> keySet = cart.keySet();
	    
	    for (CartItem item : keySet) {
	        nameBuilder.append(item.getProductName()).append(" ");
	        nameBuilder.append(item.getSizeName()).append(" ");
	        nameBuilder.append(item.getSpecName()).append(" ");
	        nameBuilder.append(cart.get(item)).append("\n");  // 使用 item 來取數量
	    }

	    return nameBuilder.toString();
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [訂購人=" + member 
				+ "\n, 購物明細: \n" + cart 
				+ String.format("\n共%s項, %s件, 總金額:%s元"
								  , size(), getTotalQuantity(), getTotalAmount()) + "]";
	}
}
